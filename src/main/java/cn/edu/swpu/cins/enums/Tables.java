package cn.edu.swpu.cins.enums;

/**
 * Created by melo on 16-5-30.
 * 数据库的表名，枚举五个行为目的表
 */
public enum Tables {
    FAPIAO("fapiao", "企业发票"),
    JIAOSHUI("jiaoshui", "企业缴税"),
    SHEBAO("shebao", "企业社保"),
    TOUBIAO("toubiao", "企业招投标"),
    NIANSHEN("nianshen", "企业信息公示");

    private String tableName;
    private String chineseName;

    Tables(String tableName, String chineseName) {
        this.tableName = tableName;
        this.chineseName = chineseName;
    }

    public static String getTableNameByQuery(String query) {
        for(Tables table : values()) {
            if (table.getTableName().equals(query))
                return table.getTableName();
        }
        return null;
    }

    public String getTableName() {
        return tableName;
    }

    public String getChineseName() {
        return chineseName;
    }

}
