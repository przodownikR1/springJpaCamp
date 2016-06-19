package pl.java.scalatech.domain.lazy;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.common.AbstractEntity;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ITEMS")
@NamedEntityGraphs({
@NamedEntityGraph(name="itemOffer",attributeNodes= {@NamedAttributeNode("offers")})
})
//@Entity
public class Item extends AbstractEntity {

    private static final long serialVersionUID = 5474170031394030929L;
    @Column(name="ITEM_NAME")
    private String name;
    private BigDecimal price;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private List<Offer> offers;


}