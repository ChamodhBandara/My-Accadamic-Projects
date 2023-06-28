import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:carousel_slider/carousel_slider.dart';

class ProductPage extends StatefulWidget {
  final String productId;

  ProductPage({required this.productId});

  @override
  _ProductPageState createState() => _ProductPageState();
}

class _ProductPageState extends State<ProductPage> {
  late Future<Map<String, dynamic>> _productData;

  @override
  void initState() {
    super.initState();
    _productData = _fetchProductData();
  }

  Future<Map<String, dynamic>> _fetchProductData() async {
    final url = 'https://dummyjson.com/products/${widget.productId}';
    final response = await http.get(Uri.parse(url));
    if (response.statusCode == 200) {
      return json.decode(response.body);
    } else {
      throw Exception('Failed to fetch product data');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Product Details'),
      ),
      body: FutureBuilder<Map<String, dynamic>>(
        future: _productData,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            final productData = snapshot.data!;
            final List<String> images =
                List<String>.from(productData['images']);
                
            final double rating = productData['rating'];
            //print(productData['rating'].runtimeType);
            final double price = productData['rating'];
            final String description = productData['description'];

            return SingleChildScrollView(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  CarouselSlider(
                    items: images
                        .map((image) => Image.network(image, fit: BoxFit.cover))
                        .toList(),
                    options: CarouselOptions(
                      autoPlay: true,
                      aspectRatio: 16 / 9,
                      enlargeCenterPage: true,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(16.0),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Row(
                          children: [
                            Icon(Icons.star, color: Colors.yellow),
                            SizedBox(width: 4.0),
                            Text(rating.toString()),
                          ],
                        ),
                        SizedBox(height: 8.0),
                        Text(
                          '\$$price',
                          style: TextStyle(
                            fontSize: 20.0,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        SizedBox(height: 8.0),
                        Text(
                          description,
                          style: TextStyle(fontSize: 16.0),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            );
          } else if (snapshot.hasError) {
            return Center(
              child: Text('Error: ${snapshot.error}'),
            );
          }
          return Center(
            child: CircularProgressIndicator(),
          );
        },
      ),
    );
  }
}





