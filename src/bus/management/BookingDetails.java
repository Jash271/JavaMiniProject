
package bus.management;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author jayme
 */
@Entity
@Table(name = "booking_details", catalog = "busm", schema = "")
@NamedQueries({
    @NamedQuery(name = "BookingDetails.findAll", query = "SELECT b FROM BookingDetails b"),
    @NamedQuery(name = "BookingDetails.findById", query = "SELECT b FROM BookingDetails b WHERE b.id = :id"),
    @NamedQuery(name = "BookingDetails.findByName", query = "SELECT b FROM BookingDetails b WHERE b.name = :name"),
    @NamedQuery(name = "BookingDetails.findBySource", query = "SELECT b FROM BookingDetails b WHERE b.source = :source"),
    @NamedQuery(name = "BookingDetails.findByDestination", query = "SELECT b FROM BookingDetails b WHERE b.destination = :destination"),
    @NamedQuery(name = "BookingDetails.findByDate", query = "SELECT b FROM BookingDetails b WHERE b.date = :date"),
    @NamedQuery(name = "BookingDetails.findByTime", query = "SELECT b FROM BookingDetails b WHERE b.time = :time")})
public class BookingDetails implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "source")
    private String source;
    @Basic(optional = false)
    @Column(name = "destination")
    private String destination;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @Column(name = "time")
    private String time;

    public BookingDetails() {
    }

    public BookingDetails(Integer id) {
        this.id = id;
    }

    public BookingDetails(Integer id, String name, String source, String destination, String date, String time) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        String oldSource = this.source;
        this.source = source;
        changeSupport.firePropertyChange("source", oldSource, source);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        String oldDestination = this.destination;
        this.destination = destination;
        changeSupport.firePropertyChange("destination", oldDestination, destination);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        String oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        String oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingDetails)) {
            return false;
        }
        BookingDetails other = (BookingDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bus.management.BookingDetails[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
