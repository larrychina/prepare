package org.larry.design.builder;

import org.larry.annotation.NotThreadSafe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 用于构建者条件查询
 */
@NotThreadSafe
public class QueryRule implements Serializable {


    public static final int EQ = 1 ;


    private List<Rule> ruleList = new ArrayList<>() ;
    /**
     * 添加等于规则
     * @return
     */
    public QueryRule addEqual(String propertyName){
        this.ruleList.add(new Rule(propertyName,EQ));
        return this;
    }


    public class Rule implements Serializable{
        private String propertyName ;
        private int type ; // 操作类型
        private String[] values ;

        public Rule() {
        }

        public Rule(String propertyName, int type) {
            this.propertyName = propertyName;
            this.type = type;
        }

        public String[] getValues() {
            return values;
        }

        public void setValues(String[] values) {
            this.values = values;
        }

        public String getPropertyName() {
            return propertyName;
        }

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public List<Rule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }
}
