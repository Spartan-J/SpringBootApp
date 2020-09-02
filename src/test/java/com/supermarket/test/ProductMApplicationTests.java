/*
 * package com.supermarket.test; import static org.mockito.BDDMockito.*; import
 * static org.hamcrest.CoreMatchers.is; import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.jupiter.api.Test; import org.mockito.Mockito; import
 * org.skyscreamer.jsonassert.JSONAssert; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * com.fasterxml.jackson.databind.ObjectMapper; import
 * com.supermarket.controller.ProductController; import
 * com.supermarket.entity.ProductEntity; import
 * com.supermarket.service.ProductService;
 * 
 * @WebMvcTest(ProductController.class) //@SpringBootTest class
 * ProductMApplicationTests {
 * 
 * @Autowired MockMvc mockMvc;
 * 
 * @Autowired ObjectMapper mapper;
 * 
 * @MockBean ProductService service;
 * 
 * 
 * @Test public void Test_listAll() throws Exception {
 * 
 * List<ProductEntity> ProductList = new ArrayList<>(); ProductEntity p1 = new
 * ProductEntity(5,"RTX",799); ProductEntity p2 = new
 * ProductEntity(6,"XFX",899); ProductList.add(p1); ProductList.add(p2);
 * 
 * // Mocking out the product service
 * Mockito.when(service.listAll()).thenReturn(ProductList);
 * 
 * MvcResult response =
 * mockMvc.perform(MockMvcRequestBuilders.get("/products").contentType(MediaType
 * .APPLICATION_JSON)) .andExpect(status().isOk()).andReturn();
 * 
 * String rs = response.getResponse().getContentAsString();
 * 
 * JSONAssert.assertEquals(mapper.writeValueAsString(ProductList), rs, false);
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * @Test public void Test_findById() throws Exception { ProductEntity p1 = new
 * ProductEntity(5,"RTX",799);
 * 
 * given(service.get(5)).willReturn(p1);
 * 
 * mockMvc.perform(get("/products/{id}",
 * 5).contentType(MediaType.APPLICATION_JSON))
 * .andExpect(status().isOk()).andExpect(jsonPath("$.name", is(p1.getName())));
 * }
 * 
 * 
 * @Test public void Test_save() throws Exception {
 * 
 * ProductEntity p1 = new ProductEntity(5,"RTX",799);
 * 
 * // when(service.save((any(Product.class));
 * 
 * given(service.save(any(ProductEntity.class))).willReturn(p1);
 * 
 * String jsonString = mapper.writeValueAsString(p1);
 * 
 * mockMvc.perform(post("/products/add")
 * .contentType(MediaType.APPLICATION_JSON).content(jsonString))
 * .andExpect(status().isOk());
 * 
 * 
 * }
 * 
 * 
 * @Test public void Test_delete() throws Exception {
 * 
 * ProductEntity p1 = new ProductEntity(5,"RTX",799);
 * 
 * given(service.get(5)).willReturn(p1);
 * 
 * Mockito.doNothing().when(service).delete(any(Integer.class));
 * 
 * mockMvc.perform(delete("/products/{id}", 5)
 * .contentType(MediaType.APPLICATION_JSON)) .andExpect(status().isOk()); }
 * 
 * }
 * 
 */