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

import net.java.antlrjavaparser.api.Node;
import net.java.antlrjavaparser.Java7Parser;
import net.java.antlrjavaparser.api.body.BodyDeclaration;

import java.util.List;

public class EnumBodyContextAdapter implements Adapter<List<BodyDeclaration>, Java7Parser.EnumBodyContext> {
    public List<BodyDeclaration> adapt(Java7Parser.EnumBodyContext context) {

        /*
        enumBody
            :    LBRACE (enumConstants)? COMMA? (enumBodyDeclarations)? RBRACE
            ;
         */

        // Enum Constants are handled in the EnumDeclaration Adapter

        if (context.enumBodyDeclarations() != null) {
            return Adapters.getEnumBodyDeclarationsContextAdapter().adapt(context.enumBodyDeclarations());
        }

        return null;
    }
}
