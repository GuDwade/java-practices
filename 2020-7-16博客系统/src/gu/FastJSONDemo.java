package gu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FastJSONDemo {
    public static void main(String[] args) {
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "peixinchen");
            jsonObject.put("age", 18);

            String str = jsonObject.toJSONString();
            System.out.println(str);
        }

        {
            JSONArray jsonArray = new JSONArray();
            jsonArray.add("peixinchen");
            jsonArray.add(18);

            String str = jsonArray.toJSONString();
            System.out.println(str);
        }

        {
            JSONArray articleList = new JSONArray();

            {
                JSONObject article = new JSONObject();

                article.put("id", 1998);

                JSONObject author = new JSONObject();
                author.put("id", 1);
                author.put("username", "peixinchen");
                article.put("author", author);

                article.put("image_id", 18);
                article.put("image_url", "/i?id=18");

                article.put("title", "今天的风儿甚是喧嚣");
                article.put("body", "街角的超市，薯片打折了");

                articleList.add(article);
            }

            {
                JSONObject article = new JSONObject();

                article.put("id", 2008);

                JSONObject author = new JSONObject();
                author.put("id", 2);
                author.put("username", "zhourong");
                article.put("author", author);

                article.put("image_id", 396);
                article.put("image_url", "/i?id=396");

                article.put("title", "震惊，关于 HashMap，面试官竟然问到这些");
                article.put("body", "同学们你们学会了么！");

                articleList.add(article);
            }

            System.out.println(articleList.toJSONString());
        }
    }
}
