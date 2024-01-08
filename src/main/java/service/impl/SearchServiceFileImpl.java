package service.impl;


import service.SearchService;

import java.util.List;

public class SearchServiceFileImpl implements SearchService {
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("文件搜索: "+keyword);
        return null;
    }
}
