##############################################################################
# OfferShareRESTful

Merchant offer good for sale and share with customers, Offers are time-bounded.
Can be cancelled before expiration. Can be seen also after expiration. Read code-screen.pdf
for complete description of the problem.

###################################################
#My others considerations at the end of this file #
###################################################

##############################################################################
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

##############################################################################
## REQUIREMENTS
Java version 1.8 or higher

##############################################################################
#Sonar site
https://sonarcloud.io/dashboard?id=giancharlock_offersharerestful

##############################################################################
#Run application
java -jar offershare.jar

##############################################################################
#Add offer

http://localhost:8080/offershare/add
{
    "id":1,
    "title":"title",
    "description":"descr",
    "currency":"EUR",
    "price":34.56,
    "expireDate":"2019-02-10 11:00"
}

##############################################################################
#Delete offer
http://localhost:8080/offershare/del/{id}

##############################################################################
#Get all offers
http://localhost:8080/offershare/all

##############################################################################
#Get all not expired offers
http://localhost:8080/offershare/notexpired

##############################################################################
#Considerations/assumptions on implementation

1) Merchant can add offer with the same id, in this case, it is a modification
2) Merchant cam modify (via add) also expired offers so that can be recovered and reused
3) Everybody can get all offers, also expired ones, but they are signed as expired=true
4) Everybody can get all not expired offers
5) User can delete offers before they expire but can delete them also if they are expired








