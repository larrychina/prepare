package org.larry.design.builder;

public class QueryRulesSqlBuilder {

    private StringBuilder sb = new StringBuilder() ;

    public QueryRulesSqlBuilder( QueryRule queryRule) {
        for (QueryRule.Rule rule :
                queryRule.getRuleList()) {

            switch (rule.getType()){
                case QueryRule.EQ:
                    // buildEq
                    break;
                default:
                    break;
            }
        }
    }

    public void buildEq(QueryRule.Rule rule){
        this.sb.append(rule.getPropertyName()).append("=").append(rule.getValues()[0]);
    }

    public String getSql(){
        return sb.toString();
    }

}
