package com.api.trees;

/**
 * Expression Node can have an operator or an operand stored in the field data
 * The operators can be +,*,- or /
 * The operands can be any number
 */
public class ExpressionNode {
    public String data;
    public ExpressionNode left,right;
    ExpressionNode(String data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
