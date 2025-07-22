package com.comicstracker.api.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
    private String id;
    private String publisher;
    private int order;
    private String title;
    @JsonProperty("period_id")
    private String periodId;
    private List<Category> categories;
    private String image;

    public static class Category {
        private String label;
        private String type;
        @JsonProperty("issue_ids")
        private List<String> issueIds;

        public String getLabel() { return label; }
        public void setLabel(String label) { this.label = label; }
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public List<String> getIssueIds() { return issueIds; }
        public void setIssueIds(List<String> issueIds) { this.issueIds = issueIds; }
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPeriodId() { return periodId; }
    public void setPeriodId(String periodId) { this.periodId = periodId; }
    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> categories) { this.categories = categories; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
