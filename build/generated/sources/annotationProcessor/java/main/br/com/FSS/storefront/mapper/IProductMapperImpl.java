package br.com.FSS.storefront.mapper;

import br.com.FSS.storefront.DTO.ProductInfoDTO;
import br.com.FSS.storefront.controller.request.ProductSaveRequest;
import br.com.FSS.storefront.controller.response.ProductAvaliableResponse;
import br.com.FSS.storefront.controller.response.ProductDetailResponse;
import br.com.FSS.storefront.controller.response.ProductSavedResponse;
import br.com.FSS.storefront.entity.ProductEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-25T12:10:15-0300",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class IProductMapperImpl implements IProductMapper {

    @Override
    public ProductInfoDTO toDTO(ProductEntity product, BigDecimal price) {
        if ( product == null && price == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        BigDecimal price1 = null;
        if ( product != null ) {
            id = product.getId();
            name = product.getName();
            price1 = product.getPrice();
        }

        ProductInfoDTO productInfoDTO = new ProductInfoDTO( id, name, price1 );

        return productInfoDTO;
    }

    @Override
    public ProductSavedResponse toResponse(ProductEntity product) {
        if ( product == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = product.getId();
        name = product.getName();

        ProductSavedResponse productSavedResponse = new ProductSavedResponse( id, name );

        return productSavedResponse;
    }

    @Override
    public ProductEntity toEntity(ProductSaveRequest request) {
        if ( request == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( request.id() );
        productEntity.setName( request.name() );
        productEntity.setDescription( request.description() );
        productEntity.setPrice( request.price() );
        productEntity.setQuantity( request.quantity() );

        productEntity.setActive( false );

        return productEntity;
    }

    @Override
    public List<ProductAvaliableResponse> toAvailableResponseList(List<ProductEntity> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductAvaliableResponse> list = new ArrayList<ProductAvaliableResponse>( products.size() );
        for ( ProductEntity productEntity : products ) {
            list.add( productEntityToProductAvaliableResponse( productEntity ) );
        }

        return list;
    }

    @Override
    public ProductDetailResponse toDetailResponse(ProductInfoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = dto.id();
        name = dto.name();

        ProductDetailResponse productDetailResponse = new ProductDetailResponse( id, name );

        return productDetailResponse;
    }

    protected ProductAvaliableResponse productEntityToProductAvaliableResponse(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductAvaliableResponse.ProductAvaliableResponseBuilder productAvaliableResponse = ProductAvaliableResponse.builder();

        productAvaliableResponse.id( productEntity.getId() );
        productAvaliableResponse.name( productEntity.getName() );
        productAvaliableResponse.description( productEntity.getDescription() );
        productAvaliableResponse.price( productEntity.getPrice() );
        productAvaliableResponse.quantity( productEntity.getQuantity() );

        return productAvaliableResponse.build();
    }
}
