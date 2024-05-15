package com.store.controller;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

@GetMapping("")
public Page<ProductDto> getProducts(Pageable pageable){
    try{
return productService.getProducts(pageable);
    }
    catch(Exception e){
e.printStackTrace();
    }

	@PostMapping("")
	public String saveProduct(@RequestBody ProductDto productDto) {
		try {
			return productService.saveProduct(productDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
