/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTWildcardBounds.java */

package net.sourceforge.pmd.lang.java.ast;

/**
 * Represents a type bound on a wildcard {@linkplain ASTTypeArgument type argument}.
 *
 * <pre class="grammar">
 *
 * WildcardBounds ::=  ( "extends" | "super" ) ( {@linkplain ASTAnnotation Annotation} )* {@linkplain ASTReferenceType ReferenceType}
 *
 * </pre>
 * @deprecated Replaced by {@link ASTWildcardType}
 */
@Deprecated
public class ASTWildcardBounds extends AbstractJavaTypeNode {

    private boolean isUpperBound;

    public ASTWildcardBounds(int id) {
        super(id);
    }


    public ASTWildcardBounds(JavaParser p, int id) {
        super(p, id);
    }

    void setUpperBound(boolean upperBound) {
        isUpperBound = upperBound;
    }

    /**
     * Returns true if this is an upper type bound, e.g.
     * in {@code <? extends Integer>}.
     */
    public boolean isUpperBound() {
        return isUpperBound;
    }


    /**
     * Returns true if this is a lower type bound, e.g.
     * in {@code <? super Node>}.
     */
    public boolean isLowerBound() {
        return !isUpperBound();
    }


    /**
     * Returns the type node representing the bound, e.g.
     * the {@code Node} in {@code <? super Node>}.
     */
    public ASTReferenceType getTypeBoundNode() {
        return getFirstChildOfType(ASTReferenceType.class);
    }


    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }


    @Override
    public <T> void jjtAccept(SideEffectingVisitor<T> visitor, T data) {
        visitor.visit(this, data);
    }
}
