package com.dly.pay.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TFenrunMxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFenrunMxExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFsjeIsNull() {
            addCriterion("fsje is null");
            return (Criteria) this;
        }

        public Criteria andFsjeIsNotNull() {
            addCriterion("fsje is not null");
            return (Criteria) this;
        }

        public Criteria andFsjeEqualTo(Double value) {
            addCriterion("fsje =", value, "fsje");
            return (Criteria) this;
        }

        public Criteria andFsjeNotEqualTo(Double value) {
            addCriterion("fsje <>", value, "fsje");
            return (Criteria) this;
        }

        public Criteria andFsjeGreaterThan(Double value) {
            addCriterion("fsje >", value, "fsje");
            return (Criteria) this;
        }

        public Criteria andFsjeGreaterThanOrEqualTo(Double value) {
            addCriterion("fsje >=", value, "fsje");
            return (Criteria) this;
        }

        public Criteria andFsjeLessThan(Double value) {
            addCriterion("fsje <", value, "fsje");
            return (Criteria) this;
        }

        public Criteria andFsjeLessThanOrEqualTo(Double value) {
            addCriterion("fsje <=", value, "fsje");
            return (Criteria) this;
        }

        public Criteria andFsjeIn(List<Double> values) {
            addCriterion("fsje in", values, "fsje");
            return (Criteria) this;
        }

        public Criteria andFsjeNotIn(List<Double> values) {
            addCriterion("fsje not in", values, "fsje");
            return (Criteria) this;
        }

        public Criteria andFsjeBetween(Double value1, Double value2) {
            addCriterion("fsje between", value1, value2, "fsje");
            return (Criteria) this;
        }

        public Criteria andFsjeNotBetween(Double value1, Double value2) {
            addCriterion("fsje not between", value1, value2, "fsje");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNull() {
            addCriterion("referee is null");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNotNull() {
            addCriterion("referee is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeEqualTo(String value) {
            addCriterion("referee =", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotEqualTo(String value) {
            addCriterion("referee <>", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThan(String value) {
            addCriterion("referee >", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThanOrEqualTo(String value) {
            addCriterion("referee >=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThan(String value) {
            addCriterion("referee <", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThanOrEqualTo(String value) {
            addCriterion("referee <=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLike(String value) {
            addCriterion("referee like", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotLike(String value) {
            addCriterion("referee not like", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeIn(List<String> values) {
            addCriterion("referee in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotIn(List<String> values) {
            addCriterion("referee not in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeBetween(String value1, String value2) {
            addCriterion("referee between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotBetween(String value1, String value2) {
            addCriterion("referee not between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andJyjeIsNull() {
            addCriterion("jyje is null");
            return (Criteria) this;
        }

        public Criteria andJyjeIsNotNull() {
            addCriterion("jyje is not null");
            return (Criteria) this;
        }

        public Criteria andJyjeEqualTo(Double value) {
            addCriterion("jyje =", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeNotEqualTo(Double value) {
            addCriterion("jyje <>", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeGreaterThan(Double value) {
            addCriterion("jyje >", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeGreaterThanOrEqualTo(Double value) {
            addCriterion("jyje >=", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeLessThan(Double value) {
            addCriterion("jyje <", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeLessThanOrEqualTo(Double value) {
            addCriterion("jyje <=", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeIn(List<Double> values) {
            addCriterion("jyje in", values, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeNotIn(List<Double> values) {
            addCriterion("jyje not in", values, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeBetween(Double value1, Double value2) {
            addCriterion("jyje between", value1, value2, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeNotBetween(Double value1, Double value2) {
            addCriterion("jyje not between", value1, value2, "jyje");
            return (Criteria) this;
        }

        public Criteria andYwlshIsNull() {
            addCriterion("ywlsh is null");
            return (Criteria) this;
        }

        public Criteria andYwlshIsNotNull() {
            addCriterion("ywlsh is not null");
            return (Criteria) this;
        }

        public Criteria andYwlshEqualTo(String value) {
            addCriterion("ywlsh =", value, "ywlsh");
            return (Criteria) this;
        }

        public Criteria andYwlshNotEqualTo(String value) {
            addCriterion("ywlsh <>", value, "ywlsh");
            return (Criteria) this;
        }

        public Criteria andYwlshGreaterThan(String value) {
            addCriterion("ywlsh >", value, "ywlsh");
            return (Criteria) this;
        }

        public Criteria andYwlshGreaterThanOrEqualTo(String value) {
            addCriterion("ywlsh >=", value, "ywlsh");
            return (Criteria) this;
        }

        public Criteria andYwlshLessThan(String value) {
            addCriterion("ywlsh <", value, "ywlsh");
            return (Criteria) this;
        }

        public Criteria andYwlshLessThanOrEqualTo(String value) {
            addCriterion("ywlsh <=", value, "ywlsh");
            return (Criteria) this;
        }

        public Criteria andYwlshLike(String value) {
            addCriterion("ywlsh like", value, "ywlsh");
            return (Criteria) this;
        }

        public Criteria andYwlshNotLike(String value) {
            addCriterion("ywlsh not like", value, "ywlsh");
            return (Criteria) this;
        }

        public Criteria andYwlshIn(List<String> values) {
            addCriterion("ywlsh in", values, "ywlsh");
            return (Criteria) this;
        }

        public Criteria andYwlshNotIn(List<String> values) {
            addCriterion("ywlsh not in", values, "ywlsh");
            return (Criteria) this;
        }

        public Criteria andYwlshBetween(String value1, String value2) {
            addCriterion("ywlsh between", value1, value2, "ywlsh");
            return (Criteria) this;
        }

        public Criteria andYwlshNotBetween(String value1, String value2) {
            addCriterion("ywlsh not between", value1, value2, "ywlsh");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}