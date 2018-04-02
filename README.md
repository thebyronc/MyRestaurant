# My Restaurant App
Working in-class app to implement new Android functionality.

This app lets you create an account, search for Restaurants via yelp api and favorite your Restaurants.

## Getting Started
To get this Android App running on your Local Device or Virtual Device:
1. In your terminal:
```
git clone https://github.com/thebyronc/MyRestaurant.git
```
2. Create a *gradle.properties* file at the root of the cloned folder. Refer to [Api Key Instructions Here](#api-key)

3. Sync the project with the updated Gradle.

4. Run the app either through your *Local Android Device* or through a *Virtual Device*.


### Api Key
Go to [https://www.yelp.com/developers/](https://www.yelp.com/developers/) to request an **Api Key** from Yelp.

You will need to create a file named *gradle.properties* and place it in the root folder of this app. Copy paste the following code into your *gradle.properties*.

**gradle.properties** :
```
YelpToken = "Bearer -Yelp_Api_Key_Here"
-org.gradle.jvmargs=-Xmx1536m
```

Replace the "Yelp_Api_Key_Here" with your own **Api Key** from Yelp.


## Author
- **Byron Chang** - [GitHub](https://github.com/thebyronc/)
