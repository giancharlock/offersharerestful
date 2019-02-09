# OfferShareRESTful

Merchant offer good for sale and share with customers, Offers are time-bounded.
Can be cancelled before expiration. Can be seen also after expiration.

## IN
Offer in shopper friendly description
Offer: title, description, price, currency, deadline

##Actors
merchant: insert/delete offer
customer: view offers
system (scheduler): set an offer as expired automatically

#OUT
RESTful service with following operations

merchant:
    insert offer, delete offer
customer:
    view not expired offers
    vier all offers not expired and expired in last X weeks
system (scheduler):
    set an offer as expired automatically, check every second


## REQUIREMENTS
Java version 1.8 or higher


