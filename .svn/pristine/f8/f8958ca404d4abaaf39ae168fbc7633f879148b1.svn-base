package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.search.pojo.SearchItem;
import com.taotao.search.pojo.SearchResult;
import com.taotao.search.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping("/query")
	@ResponseBody
	private TaotaoResult search(@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "30") int rows) {
		SearchResult result;
		try {
//			转换字符集
			keyword=new String(keyword.getBytes("iso8859-1"),"utf-8");
			result = searchService.search(keyword, page, rows);
			return TaotaoResult.ok(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteItemFromSolr(String id){
		try {
			searchService.deleteItemFromSolr(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult updateItemFromSolr(SearchItem item){
		try {
			searchService.updateItemFromSolr(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}

}
