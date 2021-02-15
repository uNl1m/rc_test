package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.AbstractMap;
import java.util.List;

public class ApiTest {
    ApiClient apiClient = new ApiClient();

    @Test
    void checkTags() {
        List<String> allTags = apiClient.getFilters();
        allTags.stream()
                .map(tag -> new AbstractMap.SimpleImmutableEntry<>(tag, apiClient.checkFilters(tag).getBody().jsonPath().<List<String>>getList("articles.tagList")))
                .forEach(articles -> articles.getValue()
                        .forEach(articleTags -> Assert.assertTrue(articleTags.contains(articles.getKey())))
                );
    }
}
