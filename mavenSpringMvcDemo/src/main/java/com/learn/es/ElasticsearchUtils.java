package com.learn.es;
//package com.yuanjin.es;
//
//import org.elasticsearch.action.index.IndexRequestBuilder;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//
//public class ElasticsearchUtils {
// 
//    private Client client;
// 
//    public ElasticsearchUtils(String clusterName, String ipAddress) {
//        Settings settings = ImmutableSettings
//                .settingsBuilder()
//                //���ü�Ⱥ���� 
//                .put("cluster.name", clusterName)
//                .put("client.transport.ignore_cluster_name", false)
//                .put("node.client", true).put("client.transport.sniff", true)
//                .build();
//        client = new TransportClient(settings)
//                .addTransportAddress(new InetSocketTransportAddress(ipAddress,
//                        9300));//�˴��˿ں�Ϊ9300
//    }
//    
//    /**
//     * ��������
//     * @param indexName �������ƣ��൱�����ݿ�����
//     * @param typeName �������ͣ��൱�����ݿ��еı���
//     * @param id id���ƣ��൱��ÿ������ĳһ�м�¼�ı�ʶ
//     * @param jsonData json����
//     */
//    public void createIndex(String indexName, String typeName, String id,
//            String jsonData) {
//        IndexRequestBuilder requestBuilder = client.prepareIndex(indexName,
//            typeName, id).setRefresh(true);//�����������ƣ��������ͣ�id
//        requestBuilder.setSource(jsonData).execute().actionGet();//��������
//    }
//
//    /**
//     * ִ������
//     * @param indexname ��������
//     * @param type ��������
//     * @param queryBuilder ��ѯ����
//     * @return
//     */
//    public SearchResponse searcher(String indexName, String typeName,
//            QueryBuilder queryBuilder) {
//        SearchResponse searchResponse = client.prepareSearch(indexName)
//                .setTypes(typeName).setQuery(queryBuilder).execute()
//                .actionGet();//ִ�в�ѯ
//        return searchResponse;
//    }
//
//    
//    /**
//     * ��������
//     * @param indexName ��������
//     * @param typeName ��������
//     * @param id id����
//     * @param jsonData json����
//     */
//    public void updateIndex(String indexName, String typeName, String id,
//            String jsonData) {
//        UpdateRequest updateRequest = new UpdateRequest();
//        updateRequest.index(indexName);//������������
//        updateRequest.id(id);//����id
//        updateRequest.type(typeName);//������������
//        updateRequest.doc(jsonData);//��������
//        client.update(updateRequest).actionGet();//ִ�и���
//    }
//
//    /**
//     * ɾ������
//     * @param indexName
//     * @param typeName
//     * @param id
//     */
//    public void deleteIndex(String indexName, String typeName, String id) {
//        client.prepareDelete(indexName, typeName, id).get();
//    }
//    
//    
//    
//    
//}
// 