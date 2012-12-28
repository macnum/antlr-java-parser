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
import net.java.antlrjavaparser.api.body.EmptyMemberDeclaration;

import java.awt.geom.Path2D;

public class InterfaceBodyDeclarationContextAdapter implements Adapter<BodyDeclaration, Java7Parser.InterfaceBodyDeclarationContext> {
    public BodyDeclaration adapt(Java7Parser.InterfaceBodyDeclarationContext context) {

        /*
        interfaceBodyDeclaration
            :   interfaceFieldDeclaration
            |   interfaceMethodDeclaration
            |   interfaceDeclaration
            |   classDeclaration
            |   SEMI
            ;
        */

        if (context.interfaceFieldDeclaration() != null) {
            return Adapters.getInterfaceFieldDeclarationContextAdapter().adapt(context.interfaceFieldDeclaration());
        } else if (context.interfaceMethodDeclaration() != null) {
            return Adapters.getInterfaceMethodDeclarationContextAdapter().adapt(context.interfaceMethodDeclaration());
        } else if (context.interfaceDeclaration() != null) {
            return Adapters.getInterfaceDeclarationContextAdapter().adapt(context.interfaceDeclaration());
        } else if (context.classDeclaration() != null) {
            return Adapters.getClassDeclarationContextAdapter().adapt(context.classDeclaration());
        } else if (context.SEMI() != null) {
            return new EmptyMemberDeclaration();
        }

        return null;
    }
}
