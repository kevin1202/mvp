package com.lofty.longan.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 图书列表
 */
public class BookResponse implements Serializable {

    /**
     * error_code : 200
     * reason : 请求成功！
     * result : {"total":15767,"limit":20,"bookList":[{"name":"灵神考试","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150603,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad613.jpg"},{"name":"虹色妖姬","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20160602,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad61f.jpg"},{"name":"好漫画","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150406,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad617.jpg"},{"name":"永恒传说","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150606,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad634.jpg"},{"name":"逆转仙师","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20160103,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad61d.jpg"},{"name":"我的同学都是外星人","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad638.jpg"},{"name":"星空六班","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad640.jpg"},{"name":"逆游戏","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad63d.jpg"},{"name":"不败战神","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad641.jpg"},{"name":"诛仙（星漫版）","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad636.jpg"},{"name":"零界点","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad63c.jpg"},{"name":"勇者与王子","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150404,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad662.jpg"},{"name":"究极钢铁侠Avengers NOW!","type":"少年漫画","area":"欧美漫画","des":"当托尼变成了反派\u2026\u2026","finish":false,"lastUpdate":20151027,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad684.jpg"},{"name":"一闪一闪亮晶晶","type":"少年漫画","area":"日本漫画","des":"提督阵亡了，他死前希望雪风活下去,可是\u2026\u2026","finish":true,"lastUpdate":20150404,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad685.jpg"},{"name":"怪物大师","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20160617,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad6d8.jpg"},{"name":"半月书院","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150607,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad709.jpg"},{"name":"龙门赏（漫客）","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20160106,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad70d.jpg"},{"name":"深国物语","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20160316,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad6d6.jpg"},{"name":"双星之阴阳师","type":"少年漫画","area":"日本漫画","des":"少年阴阳武斗剧开幕！想要守护的话就振作起来！！","finish":false,"lastUpdate":20160604,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad6d7.jpg"},{"name":"终极武器未来式","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150820,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad6ce.jpg"}]}
     */

    public int error_code;
    public String reason;
    public Result result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        /**
         * total : 15767
         * limit : 20
         * bookList : [{"name":"灵神考试","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150603,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad613.jpg"},{"name":"虹色妖姬","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20160602,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad61f.jpg"},{"name":"好漫画","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150406,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad617.jpg"},{"name":"永恒传说","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150606,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad634.jpg"},{"name":"逆转仙师","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20160103,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad61d.jpg"},{"name":"我的同学都是外星人","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad638.jpg"},{"name":"星空六班","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad640.jpg"},{"name":"逆游戏","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad63d.jpg"},{"name":"不败战神","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad641.jpg"},{"name":"诛仙（星漫版）","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad636.jpg"},{"name":"零界点","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150416,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad63c.jpg"},{"name":"勇者与王子","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150404,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad662.jpg"},{"name":"究极钢铁侠Avengers NOW!","type":"少年漫画","area":"欧美漫画","des":"当托尼变成了反派\u2026\u2026","finish":false,"lastUpdate":20151027,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad684.jpg"},{"name":"一闪一闪亮晶晶","type":"少年漫画","area":"日本漫画","des":"提督阵亡了，他死前希望雪风活下去,可是\u2026\u2026","finish":true,"lastUpdate":20150404,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad685.jpg"},{"name":"怪物大师","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20160617,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad6d8.jpg"},{"name":"半月书院","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20150607,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad709.jpg"},{"name":"龙门赏（漫客）","type":"少年漫画","area":"日本漫画","des":"","finish":false,"lastUpdate":20160106,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad70d.jpg"},{"name":"深国物语","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20160316,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad6d6.jpg"},{"name":"双星之阴阳师","type":"少年漫画","area":"日本漫画","des":"少年阴阳武斗剧开幕！想要守护的话就振作起来！！","finish":false,"lastUpdate":20160604,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad6d7.jpg"},{"name":"终极武器未来式","type":"少年漫画","area":"国漫","des":"","finish":false,"lastUpdate":20150820,"coverImg":"http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad6ce.jpg"}]
         */

        public int total;
        public int limit;
        public List<Book> bookList;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public List<Book> getBookList() {
            return bookList;
        }

        public void setBookList(List<Book> bookList) {
            this.bookList = bookList;
        }

        public static class Book {
            /**
             * name : 灵神考试
             * type : 少年漫画
             * area : 国漫
             * des :
             * finish : false
             * lastUpdate : 20150603
             * coverImg : http://imgs.juheapi.com/comic_xin/5559b86938f275fd560ad613.jpg
             */

            public String name;
            public String type;
            public String area;
            public String des;
            public boolean finish;
            public String lastUpdate;
            public String coverImg;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public boolean isFinish() {
                return finish;
            }

            public void setFinish(boolean finish) {
                this.finish = finish;
            }

            public String getLastUpdate() {
                return lastUpdate;
            }

            public void setLastUpdate(String lastUpdate) {
                this.lastUpdate = lastUpdate;
            }

            public String getCoverImg() {
                return coverImg;
            }

            public void setCoverImg(String coverImg) {
                this.coverImg = coverImg;
            }
        }
    }
}
