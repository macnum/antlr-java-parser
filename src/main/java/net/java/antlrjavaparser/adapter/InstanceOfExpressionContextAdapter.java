/*
 * This file is part of antlr-java-parser.
 *
 *     antlr-java-parser is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     antlr-java-parser is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with antlr-java-parser.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.java.antlrjavaparser.adapter;

import net.java.antlrjavaparser.Java7Parser;
import net.java.antlrjavaparser.api.expr.Expression;
import net.java.antlrjavaparser.api.expr.InstanceOfExpr;
import net.java.antlrjavaparser.api.type.Type;

public class InstanceOfExpressionContextAdapter implements Adapter<Expression, Java7Parser.InstanceOfExpressionContext> {
    public Expression adapt(Java7Parser.InstanceOfExpressionContext context) {

        Expression expression = Adapters.getRelationalExpressionContextAdapter().adapt(context.relationalExpression());

        if (context.type() != null) {
            Type type = Adapters.getTypeContextAdapter().adapt(context.type());
            InstanceOfExpr instanceOfExpr = new InstanceOfExpr();
            instanceOfExpr.setType(type);
            instanceOfExpr.setExpr(expression);
            return instanceOfExpr;
        }

        return expression;
    }
}
