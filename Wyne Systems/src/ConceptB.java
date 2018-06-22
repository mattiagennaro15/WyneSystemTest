
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;


public class ConceptB extends ConceptA
{
    private final Set<Concept> children;


    public ConceptB( final String anId, final Concept aParent )
    {
        super( anId, aParent );


        children = new HashSet<Concept>();
    }


    public int getCount()
    {
        return children.size();
    }


    public void addChild( Concept aChild )
    {
        children.add( aChild );
    }


    public void removeChild( Concept aChild )
    {
        children.remove( aChild );
    }


    public Iterator<Concept> getChildren()
    {
        return children.iterator();
    }


    public int getFamilySize()
    {
        int count = children.size();


        for ( Concept child : children )
        {
            count += ( (ConceptB) child ).getFamilySize();
        }


        return count;
    }


    public int getAncestorCount()
    {
        int count = 0;
        Concept ancestor = getParent();


        while ( ancestor != null )
        {
            count++;
            if ( ancestor instanceof ConceptA )
            {
                ancestor = ( (ConceptA) ancestor ).getParent();
            }
            else
            {
                ancestor = null;
            }
        }


        return count;
    }


    @Override
    public String toString()
    {
        return "ConceptB{" + getId() + ", parent=" + getParent() + ", children=" + children.size() + "}";
    }
}
