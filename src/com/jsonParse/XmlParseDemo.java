package com.jsonParse;

import net.sf.json.JSONObject;

public class XmlParseDemo {
    public static void main(String[] args) {
        String string = "{\"aac001\":\"30938860\",\"cpage\":\"\",\"e_time\":\"\",\"flag\":\"1\",\"manager\":\"ahygzw\",\"methodname\":\"GETCBXX\",\"msg\":\"\",\"password\":\"ahygzwcxjb\",\"req_code\":\"\",\"rows\":\"\",\"rvalue\":\"{\\\"aaa041\\\":\\\"200\\\",\\\"aab301\\\":\\\"340103\\\",\\\"aac002\\\":\\\"34011119540908201X\\\",\\\"aac003\\\":\\\"侯光亮\\\",\\\"aac004\\\":\\\"1\\\",\\\"aac005\\\":\\\"01\\\",\\\"aac006\\\":\\\"19540908\\\",\\\"aac008\\\":\\\"2\\\",\\\"aac009\\\":\\\"10\\\",\\\"aac010\\\":\\\"合肥市庐阳区亳州路街道水西门社居委\\\",\\\"aae005\\\":\\\"13605690229\\\",\\\"aae006\\\":\\\"亳州路亳州城15-604\\\",\\\"aae007\\\":\\\"230041\\\",\\\"aae010\\\":\\\"6228480661465891413\\\",\\\"aae030\\\":\\\"20120306\\\",\\\"aae031\\\":\\\"\\\",\\\"aae160\\\":\\\"\\\",\\\"aaz065\\\":\\\"农业银行\\\",\\\"aaz289\\\":\\\"002\\\",\\\"ac29List\\\":[],\\\"ac93List\\\":[],\\\"jy_grjf\\\":\\\"178.5\\\",\\\"jy_hj\\\":\\\"276.1\\\",\\\"jy_jtbz\\\":\\\"0\\\",\\\"jy_lx\\\":\\\"43.78\\\",\\\"jy_qita\\\":\\\"0\\\",\\\"jy_zfbt\\\":\\\"53.82\\\",\\\"jy_zfdj\\\":\\\"0\\\",\\\"sr_grjf\\\":\\\"300\\\",\\\"sr_hj\\\":\\\"433.78\\\",\\\"sr_jtbz\\\":\\\"0\\\",\\\"sr_lx\\\":\\\"43.78\\\",\\\"sr_qita\\\":\\\"0\\\",\\\"sr_zfbt\\\":\\\"90\\\",\\\"sr_zfdj\\\":\\\"0\\\",\\\"tssf\\\":\\\"\\\",\\\"zc_grjf\\\":\\\"121.5\\\",\\\"zc_hj\\\":\\\"157.68\\\",\\\"zc_jtbz\\\":\\\"0\\\",\\\"zc_lx\\\":\\\"0\\\",\\\"zc_qita\\\":\\\"0\\\",\\\"zc_zfbt\\\":\\\"36.18\\\",\\\"zc_zfdj\\\":\\\"0\\\",\\\"zyxx\\\":\\\"\\\"}\",\"s_time\":\"\",\"totalItems\":\"\",\"username\":\"34011119540908201X\"}";
        xmlParse(string);
    }


    private static void xmlParse(String xml) {
        JSONObject jsonObject = JSONObject.fromObject(xml);
        Object o = jsonObject.getString("aac001");
        System.out.println(o);
    }
}
