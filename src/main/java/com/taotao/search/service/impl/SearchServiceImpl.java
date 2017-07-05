package com.taotao.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.search.dao.SearchDao;
import com.taotao.search.pojo.SearchItem;
import com.taotao.search.pojo.SearchResult;
import com.taotao.search.service.SearchService;


@Service
public class SearchServiceImpl implements SearchService {

	
	@Autowired
	private SearchDao searchDao;
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public SearchResult search(String queryString, int page, int rows) throws Exception {
		// TODO Auto-generated method stub
//		创建查询条件
		SolrQuery query=new SolrQuery();
//		设置查询条件
		query.setQuery(queryString);
//		设置分页条件
		query.setStart((page-1)*rows);
		query.setRows(rows);
//		设置默认搜索域
		query.set("df", "item_title");
//		设置高亮显示
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<font class=\"skcolor_ljg\">");
		query.setHighlightSimplePost("</font>");
		
//		执行查询
		SearchResult searchResult=searchDao.search(query);
//		计算总页数
		Long recordCount=searchResult.getRecordCount();
		int pageCount=(int)(recordCount/rows);
		if(recordCount%rows>0){
			pageCount++;
		}
		searchResult.setPageCount(pageCount);
		searchResult.setCurlPage(page);
		
		return searchResult;
	}
	
	@Override
	public void deleteItemFromSolr(String itemId) throws Exception {
		// TODO Auto-generated method stub
		solrServer.deleteById(itemId);
		solrServer.commit();
	}

	@Override
	public void updateItemFromSolr(SearchItem item) throws Exception {
		// TODO Auto-generated method stub
		// 创建文档对象
		SolrInputDocument document = new SolrInputDocument();
		// 添加域
		document.addField("id", item.getId());
		document.addField("item_title", item.getTitle());
		document.addField("item_sell_point", item.getSell_point());
		document.addField("item_price", item.getPrice());
		document.addField("item_image", item.getImage());
		document.addField("item_category_name", item.getCategory_name());
		document.addField("item_desc", item.getItem_desc());
		// 写入索引库

		solrServer.add(document);
		solrServer.commit();

	}

}
