package com.dly.pay.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserCertificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserCertificationExample() {
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

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andShouchi1IsNull() {
            addCriterion("shouchi1 is null");
            return (Criteria) this;
        }

        public Criteria andShouchi1IsNotNull() {
            addCriterion("shouchi1 is not null");
            return (Criteria) this;
        }

        public Criteria andShouchi1EqualTo(String value) {
            addCriterion("shouchi1 =", value, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi1NotEqualTo(String value) {
            addCriterion("shouchi1 <>", value, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi1GreaterThan(String value) {
            addCriterion("shouchi1 >", value, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi1GreaterThanOrEqualTo(String value) {
            addCriterion("shouchi1 >=", value, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi1LessThan(String value) {
            addCriterion("shouchi1 <", value, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi1LessThanOrEqualTo(String value) {
            addCriterion("shouchi1 <=", value, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi1Like(String value) {
            addCriterion("shouchi1 like", value, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi1NotLike(String value) {
            addCriterion("shouchi1 not like", value, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi1In(List<String> values) {
            addCriterion("shouchi1 in", values, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi1NotIn(List<String> values) {
            addCriterion("shouchi1 not in", values, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi1Between(String value1, String value2) {
            addCriterion("shouchi1 between", value1, value2, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi1NotBetween(String value1, String value2) {
            addCriterion("shouchi1 not between", value1, value2, "shouchi1");
            return (Criteria) this;
        }

        public Criteria andShouchi2IsNull() {
            addCriterion("shouchi2 is null");
            return (Criteria) this;
        }

        public Criteria andShouchi2IsNotNull() {
            addCriterion("shouchi2 is not null");
            return (Criteria) this;
        }

        public Criteria andShouchi2EqualTo(String value) {
            addCriterion("shouchi2 =", value, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andShouchi2NotEqualTo(String value) {
            addCriterion("shouchi2 <>", value, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andShouchi2GreaterThan(String value) {
            addCriterion("shouchi2 >", value, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andShouchi2GreaterThanOrEqualTo(String value) {
            addCriterion("shouchi2 >=", value, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andShouchi2LessThan(String value) {
            addCriterion("shouchi2 <", value, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andShouchi2LessThanOrEqualTo(String value) {
            addCriterion("shouchi2 <=", value, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andShouchi2Like(String value) {
            addCriterion("shouchi2 like", value, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andShouchi2NotLike(String value) {
            addCriterion("shouchi2 not like", value, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andShouchi2In(List<String> values) {
            addCriterion("shouchi2 in", values, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andShouchi2NotIn(List<String> values) {
            addCriterion("shouchi2 not in", values, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andShouchi2Between(String value1, String value2) {
            addCriterion("shouchi2 between", value1, value2, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andShouchi2NotBetween(String value1, String value2) {
            addCriterion("shouchi2 not between", value1, value2, "shouchi2");
            return (Criteria) this;
        }

        public Criteria andSfz1IsNull() {
            addCriterion("sfz1 is null");
            return (Criteria) this;
        }

        public Criteria andSfz1IsNotNull() {
            addCriterion("sfz1 is not null");
            return (Criteria) this;
        }

        public Criteria andSfz1EqualTo(String value) {
            addCriterion("sfz1 =", value, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz1NotEqualTo(String value) {
            addCriterion("sfz1 <>", value, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz1GreaterThan(String value) {
            addCriterion("sfz1 >", value, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz1GreaterThanOrEqualTo(String value) {
            addCriterion("sfz1 >=", value, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz1LessThan(String value) {
            addCriterion("sfz1 <", value, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz1LessThanOrEqualTo(String value) {
            addCriterion("sfz1 <=", value, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz1Like(String value) {
            addCriterion("sfz1 like", value, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz1NotLike(String value) {
            addCriterion("sfz1 not like", value, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz1In(List<String> values) {
            addCriterion("sfz1 in", values, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz1NotIn(List<String> values) {
            addCriterion("sfz1 not in", values, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz1Between(String value1, String value2) {
            addCriterion("sfz1 between", value1, value2, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz1NotBetween(String value1, String value2) {
            addCriterion("sfz1 not between", value1, value2, "sfz1");
            return (Criteria) this;
        }

        public Criteria andSfz2IsNull() {
            addCriterion("sfz2 is null");
            return (Criteria) this;
        }

        public Criteria andSfz2IsNotNull() {
            addCriterion("sfz2 is not null");
            return (Criteria) this;
        }

        public Criteria andSfz2EqualTo(String value) {
            addCriterion("sfz2 =", value, "sfz2");
            return (Criteria) this;
        }

        public Criteria andSfz2NotEqualTo(String value) {
            addCriterion("sfz2 <>", value, "sfz2");
            return (Criteria) this;
        }

        public Criteria andSfz2GreaterThan(String value) {
            addCriterion("sfz2 >", value, "sfz2");
            return (Criteria) this;
        }

        public Criteria andSfz2GreaterThanOrEqualTo(String value) {
            addCriterion("sfz2 >=", value, "sfz2");
            return (Criteria) this;
        }

        public Criteria andSfz2LessThan(String value) {
            addCriterion("sfz2 <", value, "sfz2");
            return (Criteria) this;
        }

        public Criteria andSfz2LessThanOrEqualTo(String value) {
            addCriterion("sfz2 <=", value, "sfz2");
            return (Criteria) this;
        }

        public Criteria andSfz2Like(String value) {
            addCriterion("sfz2 like", value, "sfz2");
            return (Criteria) this;
        }

        public Criteria andSfz2NotLike(String value) {
            addCriterion("sfz2 not like", value, "sfz2");
            return (Criteria) this;
        }

        public Criteria andSfz2In(List<String> values) {
            addCriterion("sfz2 in", values, "sfz2");
            return (Criteria) this;
        }

        public Criteria andSfz2NotIn(List<String> values) {
            addCriterion("sfz2 not in", values, "sfz2");
            return (Criteria) this;
        }

        public Criteria andSfz2Between(String value1, String value2) {
            addCriterion("sfz2 between", value1, value2, "sfz2");
            return (Criteria) this;
        }

        public Criteria andSfz2NotBetween(String value1, String value2) {
            addCriterion("sfz2 not between", value1, value2, "sfz2");
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