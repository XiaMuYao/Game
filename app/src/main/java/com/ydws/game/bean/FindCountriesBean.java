package com.ydws.game.bean;

import java.util.List;

/***
 * Created by mo on 2019/1/5
 * 冷风如刀，以大地为砧板，视众生为鱼肉。
 * 万里飞雪，将穹苍作烘炉，熔万物为白银。
 **/
public class FindCountriesBean {

    /**
     * code : 200
     * message : 成功
     * data : [{"id":null,"countries":"中国","bili":null},{"id":null,"countries":"阿尔巴尼亚","bili":null},{"id":null,"countries":"阿尔及利亚","bili":null},{"id":null,"countries":"阿富汗","bili":null},{"id":null,"countries":"阿根廷","bili":null},{"id":null,"countries":"阿拉伯联合酋长国","bili":null},{"id":null,"countries":"埃及","bili":null},{"id":null,"countries":"埃塞俄比亚","bili":null},{"id":null,"countries":"爱尔兰","bili":null},{"id":null,"countries":"爱沙尼亚","bili":null},{"id":null,"countries":"安道尔","bili":null}]
     * pageNum : 0
     * pageCount : 0
     */

    private String code;
    private String message;
    private int pageNum;
    private int pageCount;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : null
         * countries : 中国
         * bili : null
         */

        private Object id;
        private String countries;
        private Object bili;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getCountries() {
            return countries;
        }

        public void setCountries(String countries) {
            this.countries = countries;
        }

        public Object getBili() {
            return bili;
        }

        public void setBili(Object bili) {
            this.bili = bili;
        }
    }
}
