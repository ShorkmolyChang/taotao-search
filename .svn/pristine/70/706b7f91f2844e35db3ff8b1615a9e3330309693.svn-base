package com.taotao.search.service;

import com.taotao.search.pojo.SearchItem;
import com.taotao.search.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page, int rows) throws Exception;

	void deleteItemFromSolr(String itemId) throws Exception;

	void updateItemFromSolr(SearchItem searchItem) throws Exception;
}
