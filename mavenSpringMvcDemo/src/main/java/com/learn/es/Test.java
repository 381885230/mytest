package com.learn.es;
//package com.yuanjin.es;
//
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
// 
//public class Test {
//    public static void main(String[] args) {
//        //�����������ü�Ⱥ���ƺ�IP��ַ
//        ElasticsearchUtils es = new ElasticsearchUtils("im_shan",
//                "localhost");
//        String indexName = "school";//��������
//        String typeName = "student";//��������
//        String id = "1";
//        String jsonData = "{" + "\"name\":\"kimchy\","
//                + "\"birth\":\"1995-01-30\"," + "\"email\":\"kimchy@163.com\""
//                + "}";//json����
//        //1.��������(ID���Զ���Ҳ�����Զ��������˴�ʹ���Զ���ID)
//        es.createIndex(indexName, typeName, id, jsonData);
// 
//        //2.ִ�в�ѯ
//        //(1)������ѯ����
//        QueryBuilder queryBuilder = QueryBuilders.termQuery("name", "kimchy");//����nameΪkimchy������
//        //(2)ִ�в�ѯ
//        SearchResponse searchResponse = es.searcher(indexName, typeName,
//            queryBuilder);
//        //(3)�������
//        SearchHits hits = searchResponse.getHits();
//        SearchHit[] searchHits = hits.getHits();
//        for (SearchHit searchHit : searchHits) {
//            String name = (String) searchHit.getSource().get("name");
//            String birth = (String) searchHit.getSource().get("birth");
//            String email = (String) searchHit.getSource().get("email");
//            System.out.println(name);
//            System.out.println(birth);
//            System.out.println(email);
//        }
// 
//        //3.��������
//        jsonData = "{" + "\"name\":\"jack\"," + "\"birth\":\"1996-01-30\","
//                + "\"email\":\"jack@163.com\"" + "}";//json����
//        es.updateIndex(indexName, typeName, id, jsonData);
// 
//        //4.ɾ������
//        es.deleteIndex(indexName, typeName, id);
//    }
//}