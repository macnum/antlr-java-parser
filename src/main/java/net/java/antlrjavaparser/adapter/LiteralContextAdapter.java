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
import net.java.antlrjavaparser.api.expr.*;

public class LiteralContextAdapter implements Adapter<LiteralExpr, Java7Parser.LiteralContext> {
    public LiteralExpr adapt(Java7Parser.LiteralContext context) {

        if (context.IntegerLiteral() != null) {
            IntegerLiteralExpr literalExpr = new IntegerLiteralExpr();
            literalExpr.setValue(context.IntegerLiteral().getText());
            return literalExpr;
        } else if (context.FloatingPointLiteral() != null) {
            DoubleLiteralExpr literalExpr = new DoubleLiteralExpr();
            literalExpr.setValue(context.FloatingPointLiteral().getText());
            return literalExpr;
        } else if (context.CharacterLiteral() != null) {
            CharLiteralExpr literalExpr = new CharLiteralExpr();
            literalExpr.setValue(context.CharacterLiteral().getText());
            return literalExpr;
        } else if (context.StringLiteral() != null) {
            StringLiteralExpr literalExpr = new StringLiteralExpr();
            literalExpr.setValue(context.StringLiteral().toString());
            return literalExpr;
        } else if (context.TRUE() != null) {
            BooleanLiteralExpr literalExpr = new BooleanLiteralExpr();
            literalExpr.setValue(true);
            return literalExpr;
        } else if (context.FALSE() != null) {
            BooleanLiteralExpr literalExpr = new BooleanLiteralExpr();
            literalExpr.setValue(false);
            return literalExpr;
        } else if (context.NULL() != null) {
            NullLiteralExpr nullLiteralExpr = new NullLiteralExpr();
            return nullLiteralExpr;
        }

        throw new RuntimeException("Unknown Literal Context");
    }
}
