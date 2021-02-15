package tests.web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class WebTest extends BaseTest {
    ElementsCollection tags = $$(".tag-list a");

    public Object[] getGetFilters() {
        open("");
        List<String> tagsText = tags.shouldBe(CollectionCondition.sizeGreaterThan(1)).texts();
        return tagsText.toArray();
    }

    @DataProvider(name = "filters-data")
    public Object[] dpMethod (){
        return getGetFilters();
    }

    @Test(dataProvider = "filters-data")
    void checkFilters(String name){
        tags.findBy(Condition.text(name)).click();
        $(".date").shouldBe(Condition.visible, Duration.ofSeconds(10));
        int sizeOfTheArticles = $$(".article-meta").size();
//        int countTags = $$("li.tag-default").filterBy(Condition.text(name)).size();
//        boolean condition = countTags >= sizeOfTheArticles;
//        Assert.assertTrue(condition);
        $$("li.tag-default").filterBy(Condition.text(name)).shouldBe(CollectionCondition.sizeGreaterThanOrEqual(sizeOfTheArticles));
    }
}
