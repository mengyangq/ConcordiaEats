package com.comp5541.ConcordiaEats.service;

import com.comp5541.ConcordiaEats.model.Product;
import com.comp5541.ConcordiaEats.repository.ProductRepository;
import com.comp5541.ConcordiaEats.repository.PurchasedRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
//import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

	@Autowired
	private PurchasedRepository purchasedRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<RecommendedProduct> getRecommendations(Integer userId) {
		List<RecommendedProduct> recommendedProducts = new ArrayList<>();
		Set<Integer> addedProductIds = new HashSet<>();

		// Fetch purchased products for the user
		List<Product> purchasedProducts = purchasedRepository.findPurchasedProductsByUserId(userId);

		// If the user has never purchased anything
		if (purchasedProducts.isEmpty()) {
			// Recommend two items on sale
			List<Product> onSaleProducts = productRepository.searchProducts().stream()
					.filter(product -> product.getOnsale() == 1).collect(Collectors.toList());
			Collections.shuffle(onSaleProducts); // Shuffle the list of on-sale products
			onSaleProducts.stream().filter(product -> !addedProductIds.contains(product.getId())).limit(2)
					.forEach(product -> {
						recommendedProducts.add(new RecommendedProduct(product, "On Sale!"));
						addedProductIds.add(product.getId());
					});

			// Recommend one item from the top five most expensive products
			List<Product> topExpensiveProducts = productRepository.searchProducts().stream()
					.sorted(Comparator.comparing(Product::getPrice).reversed()).limit(8).collect(Collectors.toList());
			Collections.shuffle(topExpensiveProducts); // Shuffle the list of top expensive products
			topExpensiveProducts.stream().filter(product -> !addedProductIds.contains(product.getId())).findFirst()
					.ifPresent(product -> {
						recommendedProducts.add(new RecommendedProduct(product, "Try something fancy!"));
						addedProductIds.add(product.getId());
					});

			return recommendedProducts;
		}

		// 1. Buy Again: Previously purchased item with the most quantity
		purchasedProducts.stream().max(Comparator.comparing(Product::getQuantity)).ifPresent(product -> {
			recommendedProducts.add(new RecommendedProduct(product, "Want to buy again?"));
			addedProductIds.add(product.getId());
		});

		// 2. On Sale: An item that is currently on sale (different from previously
		// purchased one)
		List<Product> onSaleProducts = productRepository.searchProducts().stream()
				.filter(product -> product.getOnsale() == 1) // Filter for on-sale products
				.collect(Collectors.toList());
		Collections.shuffle(onSaleProducts); // Shuffle the list of on-sale products
		onSaleProducts.stream().filter(product -> !addedProductIds.contains(product.getId())) // Exclude already added
																								// products
				.findFirst() // Select the first available on-sale product
				.ifPresent(product -> {
					recommendedProducts.add(new RecommendedProduct(product, "On Sale!"));
					addedProductIds.add(product.getId());
				});
		// If less than three recommendations, recommend one item from the top five most
		// expensive products
		if (recommendedProducts.size() < 3) {
			List<Product> topExpensiveProducts = productRepository.searchProducts().stream()
					.sorted(Comparator.comparing(Product::getPrice).reversed()).limit(8).collect(Collectors.toList());
			Collections.shuffle(topExpensiveProducts); // Shuffle the list of top expensive products
			topExpensiveProducts.stream().filter(product -> !addedProductIds.contains(product.getId())).findFirst()
					.ifPresent(product -> {
						recommendedProducts.add(new RecommendedProduct(product, "Try something fancy!"));
						addedProductIds.add(product.getId());
					});
		}

		return recommendedProducts;
	}

	public static class RecommendedProduct {
		private Product product;
		private String caption;

		public RecommendedProduct(Product product, String caption) {
			this.product = product;
			this.caption = caption;
		}

		public Product getProduct() {
			return product;
		}

		public String getCaption() {
			return caption;
		}
	}
}
