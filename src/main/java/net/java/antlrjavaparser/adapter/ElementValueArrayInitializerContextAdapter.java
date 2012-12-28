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
import net.java.antlrjavaparser.api.expr.ArrayInitializerExpr;
import net.java.antlrjavaparser.api.expr.Expression;

import java.util.LinkedList;
import java.util.List;

public class ElementValueArrayInitializerContextAdapter implements Adapter<ArrayInitializerExpr, Java7Parser.ElementValueArrayInitializerContext> {
    public ArrayInitializerExpr adapt(Java7Parser.ElementValueArrayInitializerContext context) {
        /*
            elementValueArrayInitializer
            :   LBRACE
                    (elementValue
                            (COMMA elementValue
                            )*
                    )? (COMMA)? RBRACE
            ;
        */
        ArrayInitializerExpr arrayInitializerExpr = new ArrayInitializerExpr();

        List<Expression> expressionList = new LinkedList<Expression>();
        for (Java7Parser.ElementValueContext elementValueContext : context.elementValue()) {
            expressionList.add(Adapters.getElementValueContextAdapter().adapt(elementValueContext));
        }
        arrayInitializerExpr.setValues(expressionList);

        return arrayInitializerExpr;
    }
}
