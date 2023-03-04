# fruit-shop

I tried to organize the packages by domain.

At the end of my Order endpoint I started receiving an error to create the Order and Order Line tables and could not figure out what happened. So it's running fine just before the Order commit.

I developed it using STS last version for linux.

I also tried to imagine the Offer solution and created an entity for it:

Depending on the product being bought (not null) and having on of the amount or price info (optioinal but not both optional) it can use another product or not (in case of the same product it is null) and give an amount of it or a discount on it.

For sure the implementation of the part is probably the best part.

Wish the best.

João Paulo Ferreira