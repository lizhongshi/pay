package com.dly.pay.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andCreationTimeIsNull() {
            addCriterion("creation_time is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(Date value) {
            addCriterion("creation_time =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(Date value) {
            addCriterion("creation_time <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(Date value) {
            addCriterion("creation_time >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_time >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(Date value) {
            addCriterion("creation_time <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("creation_time <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<Date> values) {
            addCriterion("creation_time in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<Date> values) {
            addCriterion("creation_time not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(Date value1, Date value2) {
            addCriterion("creation_time between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("creation_time not between", value1, value2, "creationTime");
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

        public Criteria andJyjeEqualTo(String value) {
            addCriterion("jyje =", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeNotEqualTo(String value) {
            addCriterion("jyje <>", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeGreaterThan(String value) {
            addCriterion("jyje >", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeGreaterThanOrEqualTo(String value) {
            addCriterion("jyje >=", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeLessThan(String value) {
            addCriterion("jyje <", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeLessThanOrEqualTo(String value) {
            addCriterion("jyje <=", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeLike(String value) {
            addCriterion("jyje like", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeNotLike(String value) {
            addCriterion("jyje not like", value, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeIn(List<String> values) {
            addCriterion("jyje in", values, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeNotIn(List<String> values) {
            addCriterion("jyje not in", values, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeBetween(String value1, String value2) {
            addCriterion("jyje between", value1, value2, "jyje");
            return (Criteria) this;
        }

        public Criteria andJyjeNotBetween(String value1, String value2) {
            addCriterion("jyje not between", value1, value2, "jyje");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("pay_status like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("pay_status not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Integer value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Integer value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Integer value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Integer value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Integer> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Integer> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("card_no in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("card_no not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andGrbhIsNull() {
            addCriterion("grbh is null");
            return (Criteria) this;
        }

        public Criteria andGrbhIsNotNull() {
            addCriterion("grbh is not null");
            return (Criteria) this;
        }

        public Criteria andGrbhEqualTo(String value) {
            addCriterion("grbh =", value, "grbh");
            return (Criteria) this;
        }

        public Criteria andGrbhNotEqualTo(String value) {
            addCriterion("grbh <>", value, "grbh");
            return (Criteria) this;
        }

        public Criteria andGrbhGreaterThan(String value) {
            addCriterion("grbh >", value, "grbh");
            return (Criteria) this;
        }

        public Criteria andGrbhGreaterThanOrEqualTo(String value) {
            addCriterion("grbh >=", value, "grbh");
            return (Criteria) this;
        }

        public Criteria andGrbhLessThan(String value) {
            addCriterion("grbh <", value, "grbh");
            return (Criteria) this;
        }

        public Criteria andGrbhLessThanOrEqualTo(String value) {
            addCriterion("grbh <=", value, "grbh");
            return (Criteria) this;
        }

        public Criteria andGrbhLike(String value) {
            addCriterion("grbh like", value, "grbh");
            return (Criteria) this;
        }

        public Criteria andGrbhNotLike(String value) {
            addCriterion("grbh not like", value, "grbh");
            return (Criteria) this;
        }

        public Criteria andGrbhIn(List<String> values) {
            addCriterion("grbh in", values, "grbh");
            return (Criteria) this;
        }

        public Criteria andGrbhNotIn(List<String> values) {
            addCriterion("grbh not in", values, "grbh");
            return (Criteria) this;
        }

        public Criteria andGrbhBetween(String value1, String value2) {
            addCriterion("grbh between", value1, value2, "grbh");
            return (Criteria) this;
        }

        public Criteria andGrbhNotBetween(String value1, String value2) {
            addCriterion("grbh not between", value1, value2, "grbh");
            return (Criteria) this;
        }

        public Criteria andShbhIsNull() {
            addCriterion("shbh is null");
            return (Criteria) this;
        }

        public Criteria andShbhIsNotNull() {
            addCriterion("shbh is not null");
            return (Criteria) this;
        }

        public Criteria andShbhEqualTo(String value) {
            addCriterion("shbh =", value, "shbh");
            return (Criteria) this;
        }

        public Criteria andShbhNotEqualTo(String value) {
            addCriterion("shbh <>", value, "shbh");
            return (Criteria) this;
        }

        public Criteria andShbhGreaterThan(String value) {
            addCriterion("shbh >", value, "shbh");
            return (Criteria) this;
        }

        public Criteria andShbhGreaterThanOrEqualTo(String value) {
            addCriterion("shbh >=", value, "shbh");
            return (Criteria) this;
        }

        public Criteria andShbhLessThan(String value) {
            addCriterion("shbh <", value, "shbh");
            return (Criteria) this;
        }

        public Criteria andShbhLessThanOrEqualTo(String value) {
            addCriterion("shbh <=", value, "shbh");
            return (Criteria) this;
        }

        public Criteria andShbhLike(String value) {
            addCriterion("shbh like", value, "shbh");
            return (Criteria) this;
        }

        public Criteria andShbhNotLike(String value) {
            addCriterion("shbh not like", value, "shbh");
            return (Criteria) this;
        }

        public Criteria andShbhIn(List<String> values) {
            addCriterion("shbh in", values, "shbh");
            return (Criteria) this;
        }

        public Criteria andShbhNotIn(List<String> values) {
            addCriterion("shbh not in", values, "shbh");
            return (Criteria) this;
        }

        public Criteria andShbhBetween(String value1, String value2) {
            addCriterion("shbh between", value1, value2, "shbh");
            return (Criteria) this;
        }

        public Criteria andShbhNotBetween(String value1, String value2) {
            addCriterion("shbh not between", value1, value2, "shbh");
            return (Criteria) this;
        }

        public Criteria andDzCardNoIsNull() {
            addCriterion("dz_card_no is null");
            return (Criteria) this;
        }

        public Criteria andDzCardNoIsNotNull() {
            addCriterion("dz_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andDzCardNoEqualTo(String value) {
            addCriterion("dz_card_no =", value, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andDzCardNoNotEqualTo(String value) {
            addCriterion("dz_card_no <>", value, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andDzCardNoGreaterThan(String value) {
            addCriterion("dz_card_no >", value, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andDzCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("dz_card_no >=", value, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andDzCardNoLessThan(String value) {
            addCriterion("dz_card_no <", value, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andDzCardNoLessThanOrEqualTo(String value) {
            addCriterion("dz_card_no <=", value, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andDzCardNoLike(String value) {
            addCriterion("dz_card_no like", value, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andDzCardNoNotLike(String value) {
            addCriterion("dz_card_no not like", value, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andDzCardNoIn(List<String> values) {
            addCriterion("dz_card_no in", values, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andDzCardNoNotIn(List<String> values) {
            addCriterion("dz_card_no not in", values, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andDzCardNoBetween(String value1, String value2) {
            addCriterion("dz_card_no between", value1, value2, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andDzCardNoNotBetween(String value1, String value2) {
            addCriterion("dz_card_no not between", value1, value2, "dzCardNo");
            return (Criteria) this;
        }

        public Criteria andIszfIsNull() {
            addCriterion("iszf is null");
            return (Criteria) this;
        }

        public Criteria andIszfIsNotNull() {
            addCriterion("iszf is not null");
            return (Criteria) this;
        }

        public Criteria andIszfEqualTo(Boolean value) {
            addCriterion("iszf =", value, "iszf");
            return (Criteria) this;
        }

        public Criteria andIszfNotEqualTo(Boolean value) {
            addCriterion("iszf <>", value, "iszf");
            return (Criteria) this;
        }

        public Criteria andIszfGreaterThan(Boolean value) {
            addCriterion("iszf >", value, "iszf");
            return (Criteria) this;
        }

        public Criteria andIszfGreaterThanOrEqualTo(Boolean value) {
            addCriterion("iszf >=", value, "iszf");
            return (Criteria) this;
        }

        public Criteria andIszfLessThan(Boolean value) {
            addCriterion("iszf <", value, "iszf");
            return (Criteria) this;
        }

        public Criteria andIszfLessThanOrEqualTo(Boolean value) {
            addCriterion("iszf <=", value, "iszf");
            return (Criteria) this;
        }

        public Criteria andIszfIn(List<Boolean> values) {
            addCriterion("iszf in", values, "iszf");
            return (Criteria) this;
        }

        public Criteria andIszfNotIn(List<Boolean> values) {
            addCriterion("iszf not in", values, "iszf");
            return (Criteria) this;
        }

        public Criteria andIszfBetween(Boolean value1, Boolean value2) {
            addCriterion("iszf between", value1, value2, "iszf");
            return (Criteria) this;
        }

        public Criteria andIszfNotBetween(Boolean value1, Boolean value2) {
            addCriterion("iszf not between", value1, value2, "iszf");
            return (Criteria) this;
        }

        public Criteria andIsdzIsNull() {
            addCriterion("isdz is null");
            return (Criteria) this;
        }

        public Criteria andIsdzIsNotNull() {
            addCriterion("isdz is not null");
            return (Criteria) this;
        }

        public Criteria andIsdzEqualTo(Boolean value) {
            addCriterion("isdz =", value, "isdz");
            return (Criteria) this;
        }

        public Criteria andIsdzNotEqualTo(Boolean value) {
            addCriterion("isdz <>", value, "isdz");
            return (Criteria) this;
        }

        public Criteria andIsdzGreaterThan(Boolean value) {
            addCriterion("isdz >", value, "isdz");
            return (Criteria) this;
        }

        public Criteria andIsdzGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isdz >=", value, "isdz");
            return (Criteria) this;
        }

        public Criteria andIsdzLessThan(Boolean value) {
            addCriterion("isdz <", value, "isdz");
            return (Criteria) this;
        }

        public Criteria andIsdzLessThanOrEqualTo(Boolean value) {
            addCriterion("isdz <=", value, "isdz");
            return (Criteria) this;
        }

        public Criteria andIsdzIn(List<Boolean> values) {
            addCriterion("isdz in", values, "isdz");
            return (Criteria) this;
        }

        public Criteria andIsdzNotIn(List<Boolean> values) {
            addCriterion("isdz not in", values, "isdz");
            return (Criteria) this;
        }

        public Criteria andIsdzBetween(Boolean value1, Boolean value2) {
            addCriterion("isdz between", value1, value2, "isdz");
            return (Criteria) this;
        }

        public Criteria andIsdzNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isdz not between", value1, value2, "isdz");
            return (Criteria) this;
        }

        public Criteria andDzTimeIsNull() {
            addCriterion("dz_time is null");
            return (Criteria) this;
        }

        public Criteria andDzTimeIsNotNull() {
            addCriterion("dz_time is not null");
            return (Criteria) this;
        }

        public Criteria andDzTimeEqualTo(Date value) {
            addCriterion("dz_time =", value, "dzTime");
            return (Criteria) this;
        }

        public Criteria andDzTimeNotEqualTo(Date value) {
            addCriterion("dz_time <>", value, "dzTime");
            return (Criteria) this;
        }

        public Criteria andDzTimeGreaterThan(Date value) {
            addCriterion("dz_time >", value, "dzTime");
            return (Criteria) this;
        }

        public Criteria andDzTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dz_time >=", value, "dzTime");
            return (Criteria) this;
        }

        public Criteria andDzTimeLessThan(Date value) {
            addCriterion("dz_time <", value, "dzTime");
            return (Criteria) this;
        }

        public Criteria andDzTimeLessThanOrEqualTo(Date value) {
            addCriterion("dz_time <=", value, "dzTime");
            return (Criteria) this;
        }

        public Criteria andDzTimeIn(List<Date> values) {
            addCriterion("dz_time in", values, "dzTime");
            return (Criteria) this;
        }

        public Criteria andDzTimeNotIn(List<Date> values) {
            addCriterion("dz_time not in", values, "dzTime");
            return (Criteria) this;
        }

        public Criteria andDzTimeBetween(Date value1, Date value2) {
            addCriterion("dz_time between", value1, value2, "dzTime");
            return (Criteria) this;
        }

        public Criteria andDzTimeNotBetween(Date value1, Date value2) {
            addCriterion("dz_time not between", value1, value2, "dzTime");
            return (Criteria) this;
        }

        public Criteria andDzStatusIsNull() {
            addCriterion("dz_status is null");
            return (Criteria) this;
        }

        public Criteria andDzStatusIsNotNull() {
            addCriterion("dz_status is not null");
            return (Criteria) this;
        }

        public Criteria andDzStatusEqualTo(String value) {
            addCriterion("dz_status =", value, "dzStatus");
            return (Criteria) this;
        }

        public Criteria andDzStatusNotEqualTo(String value) {
            addCriterion("dz_status <>", value, "dzStatus");
            return (Criteria) this;
        }

        public Criteria andDzStatusGreaterThan(String value) {
            addCriterion("dz_status >", value, "dzStatus");
            return (Criteria) this;
        }

        public Criteria andDzStatusGreaterThanOrEqualTo(String value) {
            addCriterion("dz_status >=", value, "dzStatus");
            return (Criteria) this;
        }

        public Criteria andDzStatusLessThan(String value) {
            addCriterion("dz_status <", value, "dzStatus");
            return (Criteria) this;
        }

        public Criteria andDzStatusLessThanOrEqualTo(String value) {
            addCriterion("dz_status <=", value, "dzStatus");
            return (Criteria) this;
        }

        public Criteria andDzStatusLike(String value) {
            addCriterion("dz_status like", value, "dzStatus");
            return (Criteria) this;
        }

        public Criteria andDzStatusNotLike(String value) {
            addCriterion("dz_status not like", value, "dzStatus");
            return (Criteria) this;
        }

        public Criteria andDzStatusIn(List<String> values) {
            addCriterion("dz_status in", values, "dzStatus");
            return (Criteria) this;
        }

        public Criteria andDzStatusNotIn(List<String> values) {
            addCriterion("dz_status not in", values, "dzStatus");
            return (Criteria) this;
        }

        public Criteria andDzStatusBetween(String value1, String value2) {
            addCriterion("dz_status between", value1, value2, "dzStatus");
            return (Criteria) this;
        }

        public Criteria andDzStatusNotBetween(String value1, String value2) {
            addCriterion("dz_status not between", value1, value2, "dzStatus");
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