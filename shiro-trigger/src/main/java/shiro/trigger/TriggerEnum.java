package shiro.trigger;

/**
 * 触发器枚举类
 */
public interface TriggerEnum {

    String getDesc();

    enum State implements TriggerEnum {
        ON("启用"), OFF("禁用");

        private String desc;

        State(String desc) {
            this.desc = desc;
        }

        @Override
        public String getDesc() {
            return null;
        }
    }

    enum Type implements TriggerEnum {
        EVENT("事件触发"), CHECK("时间触发");

        private String desc;

        Type(String desc) {
            this.desc = desc;
        }

        @Override
        public String getDesc() {
            return desc;
        }
    }

    enum Event implements TriggerEnum {
        ;

        @Override
        public String getDesc() {
            return null;
        }
    }

    enum Check implements  TriggerEnum {
        CHECK_RETURN_VISIT("回访记录");

        private String desc;

        Check(String desc) {
            this.desc = desc;
        }

        @Override
        public String getDesc() {
            return desc;
        }
    }
}
