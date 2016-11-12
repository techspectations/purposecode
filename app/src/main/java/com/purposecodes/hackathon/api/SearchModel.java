package com.purposecodes.hackathon.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PURPOSE CODE on 11/12/2016.
 */

public class SearchModel {

    @SerializedName("searchType")
    @Expose
    private String searchType;
    @SerializedName("articlesMatched")
    @Expose
    private Integer articlesMatched;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;
    @SerializedName("articlesCount")
    @Expose
    private Integer articlesCount;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = new ArrayList<Article>();

    /**
     *
     * @return
     * The searchType
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     *
     * @param searchType
     * The searchType
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     *
     * @return
     * The articlesMatched
     */
    public Integer getArticlesMatched() {
        return articlesMatched;
    }

    /**
     *
     * @param articlesMatched
     * The articlesMatched
     */
    public void setArticlesMatched(Integer articlesMatched) {
        this.articlesMatched = articlesMatched;
    }

    /**
     *
     * @return
     * The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param page
     * The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     *
     * @return
     * The totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     *
     * @param totalPages
     * The totalPages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     *
     * @return
     * The articlesCount
     */
    public Integer getArticlesCount() {
        return articlesCount;
    }

    /**
     *
     * @param articlesCount
     * The articlesCount
     */
    public void setArticlesCount(Integer articlesCount) {
        this.articlesCount = articlesCount;
    }

    /**
     *
     * @return
     * The articles
     */
    public List<Article> getArticles() {
        return articles;
    }

    /**
     *
     * @param articles
     * The articles
     */
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public class Article {

        @SerializedName("articleID")
        @Expose
        private String articleID;
        @SerializedName("articleSection")
        @Expose
        private String articleSection;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("articleURL")
        @Expose
        private String articleURL;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        @SerializedName("imgWeb")
        @Expose
        private String imgWeb;
        @SerializedName("imgMob")
        @Expose
        private String imgMob;
        @SerializedName("lastModified")
        @Expose
        private String lastModified;
        @SerializedName("otherImages")
        @Expose
        private String otherImages;
        @SerializedName("video")
        @Expose
        private String video;

        /**
         *
         * @return
         * The articleID
         */
        public String getArticleID() {
            return articleID;
        }

        /**
         *
         * @param articleID
         * The articleID
         */
        public void setArticleID(String articleID) {
            this.articleID = articleID;
        }

        /**
         *
         * @return
         * The articleSection
         */
        public String getArticleSection() {
            return articleSection;
        }

        /**
         *
         * @param articleSection
         * The articleSection
         */
        public void setArticleSection(String articleSection) {
            this.articleSection = articleSection;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The articleURL
         */
        public String getArticleURL() {
            return articleURL;
        }

        /**
         *
         * @param articleURL
         * The articleURL
         */
        public void setArticleURL(String articleURL) {
            this.articleURL = articleURL;
        }

        /**
         *
         * @return
         * The thumbnail
         */
        public String getThumbnail() {
            return thumbnail;
        }

        /**
         *
         * @param thumbnail
         * The thumbnail
         */
        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        /**
         *
         * @return
         * The imgWeb
         */
        public String getImgWeb() {
            return imgWeb;
        }

        /**
         *
         * @param imgWeb
         * The imgWeb
         */
        public void setImgWeb(String imgWeb) {
            this.imgWeb = imgWeb;
        }

        /**
         *
         * @return
         * The imgMob
         */
        public String getImgMob() {
            return imgMob;
        }

        /**
         *
         * @param imgMob
         * The imgMob
         */
        public void setImgMob(String imgMob) {
            this.imgMob = imgMob;
        }

        /**
         *
         * @return
         * The lastModified
         */
        public String getLastModified() {
            return lastModified;
        }

        /**
         *
         * @param lastModified
         * The lastModified
         */
        public void setLastModified(String lastModified) {
            this.lastModified = lastModified;
        }

        /**
         *
         * @return
         * The otherImages
         */
        public String getOtherImages() {
            return otherImages;
        }

        /**
         *
         * @param otherImages
         * The otherImages
         */
        public void setOtherImages(String otherImages) {
            this.otherImages = otherImages;
        }

        /**
         *
         * @return
         * The video
         */
        public String getVideo() {
            return video;
        }

        /**
         *
         * @param video
         * The video
         */
        public void setVideo(String video) {
            this.video = video;
        }

    }
}
