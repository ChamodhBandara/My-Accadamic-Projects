import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

import 'detailsView.dart';


class HomePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<dynamic> productList = [];
  bool isLoading = true;
  String error = '';

  @override
  void initState() {
    super.initState();
    fetchProducts();
  }

  Future<void> fetchProducts() async {
    try {
      final response =
          await http.get(Uri.parse('https://dummyjson.com/products'));
      if (response.statusCode == 200) {
        final jsonData = json.decode(response.body);
        if (jsonData is Map<String, dynamic> &&
            jsonData.containsKey('products')) {
          setState(() {
            productList = jsonData['products'];
            isLoading = false;
          });
        } else {
          setState(() {
            isLoading = false;
            error = 'Invalid response format';
          });
        }
      } else {
        setState(() {
          isLoading = false;
          error =
              'Failed to load products. Status code: ${response.statusCode}';
        });
      }
    } catch (e) {
      setState(() {
        isLoading = false;
        error = 'Error: $e';
      });
    }
  }

  void navigateToDetails(String productId) {
    // Navigate to the details view layout
    Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => ProductPage(productId: productId)),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Product List'),
      ),
      body: isLoading
          ? Center(child: CircularProgressIndicator())
          : error.isNotEmpty
              ? Center(child: Text(error))
              : ListView.builder(
                  itemCount: productList.length,
                  itemBuilder: (context, index) {
                    final product = productList[index];
                    final name = product['title'] ?? 'Unknown Product';
                    final productId = product['id'].toString(); // Assuming 'id' is the key for the product ID
                    return GestureDetector(
                      onTap:()=> navigateToDetails(productId), // Attach the navigation method to onTap
                      child: ListTile(
                        title: Text(name),
                        subtitle: Text(product['description'] ?? ''),
                        leading: Image.network(product['thumbnail'] ?? ''),
                      ),
                    );
                  },
                ),
    
    );
  }
}

class DetailsPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Details Page'),
      ),
      body: Center(
        child: Text('Details View'),
      ),
    );
  }
}





