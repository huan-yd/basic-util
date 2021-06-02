package com.huan.constants;

/**
 * 常量
 */
public interface Constant {
    /**
     * 成功
     */
    int SUCCESS = 1;
    /**
     * 失败
     */
    int FAIL = 0;
    /**
     * OK
     */
    String OK = "OK";
    /**
     * 用户标识
     */
    String USER_KEY = "userId";
    /**
     * 菜单根节点标识
     */
    Long MENU_ROOT = 0L;
    /**
     * 部门根节点标识
     */
    Long DEPT_ROOT = 0L;
    /**
     * 数据字典根节点标识
     */
    Long DICT_ROOT = 0L;
    /**
     * 升序
     */
    String ASC = "asc";
    /**
     * 降序
     */
    String DESC = "desc";
    /**
     * 创建时间字段名
     */
    String CREATE_DATE = "create_date";
    String CREATE_TIME = "create_time";
    /**
     * 创建时间字段名
     */
    String ID = "id";

    /**
     * 数据权限过滤
     */
    String SQL_FILTER = "sqlFilter";

    /**
     * 当前页码
     */
    String PAGE = "page";
    /**
     * 每页显示记录数
     */
    String LIMIT = "limit";
    /**
     * 查询总数
     */
    String SEARCH_COUNT = "searchCount";
    /**
     * 默认每页条目20,最大条目数100
     */
    int DEFAULT_LIMIT = 20;
    int MAX_LIMIT = 100;
    /**
     * 排序字段
     */
    String ORDER_FIELD = "orderField";
    /**
     * 排序方式
     */
    String ORDER = "order";
    /**
     * token header
     */
    String TOKEN_HEADER = "token";
    /**
     * token过期
     */
    String TOKEN_EXPIRE = "expire";

    String QUANZHOU_CODE = "350500";
    /**
     * 云存储配置KEY
     */
    String CLOUD_STORAGE_CONFIG_KEY = "CLOUD_STORAGE_CONFIG_KEY";
    /**
     * 短信配置KEY
     */
    String SMS_CONFIG_KEY = "SMS_CONFIG_KEY";
    /**
     * 邮件配置KEY
     */
    String MAIL_CONFIG_KEY = "MAIL_CONFIG_KEY";

    /**
     * 泉州市总工会组织id
     */
    Long ROOT_OTG_DEPT_ID = 1120225747671756801L;
    /*
    * 泉州市总工会_办公室部门id
    * */
    Long OFFICE_DEPT_ID = 1067246875800000081L;
    /**
     * 泉州市管理员用户id
     */
    String QUANZHOU_ADMIN_USER_ID = "1067246875800000001";
    /**
     * 泉州市总用户id
     */
    String QUANZHOU_CITY_CHIEF_USER_ID = "ccc534ac00fba92f404854b4ff13b989";

    /**
     * 对外组织树key前缀
     */
    String OPEN_ORG_TREE_PREFIX = "tree:openOrgTreeList:";

    /**
     * 组织树key前缀
     */
    String ORG_TREE_PREFIX = "tree:orgTreeList:";

    /**
     * 组织部门树key前缀
     */
    String ORG_DEPT_TREE_PREFIX = "tree:orgAndDeptTreeList:";

    /**
     * 定时任务状态
     */
    enum ScheduleStatus {
        /**
         * 暂停
         */
        PAUSE(0),
        /**
         * 正常
         */
        NORMAL(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3),
        /**
         * FASTDFS
         */
        FASTDFS(4),
        /**
         * 本地
         */
        LOCAL(5);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 短信服务商
     */
    enum SmsService {
        /**
         * 阿里云
         */
        ALIYUN(1),
        /**
         * 腾讯云
         */
        QCLOUD(2),
        /**
         * 希奥
         */
        XIAO(3),
        /**
         * 中国移动MAS平台
         */
        CHINAMOBILE(4);

        private int value;

        SmsService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }



    /**
     * 文件上传目录
     */
    enum UPLOAD_PATH {
        ORG("/org/"),

        MEMBER ("/member/"),

        CMS("/cms/");



        private String value;

        UPLOAD_PATH(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 文件上传目录
     */
    enum EXCEL {
        xls("xls"),

        xlsx ("xlsx");

        private String value;

        EXCEL(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    String importLog = "import_log:";
}