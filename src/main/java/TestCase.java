import service.SearchService;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestCase {
    public static void main(String[] args) {
        ServiceLoader<SearchService> s = ServiceLoader.load(SearchService.class);
        Iterator<SearchService> iterator = s.iterator();
        while (iterator.hasNext()) {
            SearchService search =  iterator.next();
            search.searchDoc("hello world");
        }
    }
}