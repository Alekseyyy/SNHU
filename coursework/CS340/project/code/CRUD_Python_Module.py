
#
# A simple Python interface library
#   for instances of MongoDB.
#
# By Alexander Ahmann <alexander.ahmann@snhu.edu>
#

from pymongo import MongoClient
from bson.objectid import ObjectId 

class AnimalShelter(object): 
    """ CRUD operations for Animal collection in MongoDB """ 

    # Initializing the MongoClient. This helps to access the MongoDB 
    # databases and collections. I have modified the constructor
    # to take in configs when being instantiated.
    def __init__(self, USER, PASS, HOST):
        """
        AnimalShelter() __init__ constructor
        
        Args:
          USER (str): the username to login to the MongoDB instance with.
          PASS (str): the password to login to the MongoDB instance.
          HOST (str): the hostname, or IP address, of the MongoDB instance.
        """
        
        # Check to see if given arguments meet the proper types:
        if not isinstance(USER, str):
            raise Exception("'USER' should be a string type")
        elif not isinstance(PASS, str):
            raise Exception("'PASS' should be a string type")
        elif not isinstance(HOST, str):
            raise Exception("'HOST' should be a string type")

        # Other configurations
        PORT = 27017
        DB = "aac"
        COL = "animals"
        
        # Initialize Connection 
        self.client = MongoClient('mongodb://%s:%s@%s:%d' % (USER,PASS,HOST,PORT)) 
        self.database = self.client['%s' % (DB)] 
        self.collection = self.database['%s' % (COL)] 

    # "Create" [C]RUD
    def create(self, data: dict) -> bool:
        """
        A function that inserts a document into a specified 
          MongoDB database and collection
        
        Args:
          data (dictionary): the actual dictionary, which is to be
            inserted as a BSON document.
        
        Returns:
          bool: A "True" if the operation was successful, otherwise a
            "False" if the operation was not successful.
        """
        
        try:
            if data is None:
                raise Exception("The data type should not be 'None'")
            elif not isinstance(data, dict):
                raise Exception("The data type should be a dictionary")
            else:
                obj_id = ObjectId()
                document = {"_id":obj_id}
                document.update(data)
                # NOTE that I have updated the ``create()`` function to auto-
                # -matically insert a new, unique ObjectId.
                
                self.database.animals.insert_one(document)
                return True
        except Exception as e:
            print("Exception raised: {0}".format(e))
            return False
        
        return False

    # "Read" C[R]UD method
    def read(self, query: dict) -> list:
        """
        A function that queries for document(s) from a specified 
          MongoDB database and specified collection
          
        Args:
          query (dictionary): the filter criteria to be applied when
            finding documents (if no such criteria is needed, just put
            an empty dictionary: {}).
        
        Returns:
          list: A list of documents from the MongoDB collection that
            matches the given criteria.
        """
        
        results = []
        try:
            if not isinstance(query, dict):
                raise Exception("'query' should be a dictionary")
            else:
                query_results = self.collection.find(query)
                results.extend([doc for doc in query_results]) # the results of the find query                    
        except Exception as e:
            print("Exception raised: {0}".format(e))
        
        return results # or, in case of an exception.
    
    # "Update" CR[U]D method 
    def update(self, query: dict, data: dict) -> int:
        """
        An function that queries for and changes document(s) from a specified 
          MongoDB database and specified collection
          
        Args:
          query (dictionary): a filter criteria.
          data (dictionary): the fields to update, and which values to
            replace their current ones with. The "$set" operation has al-
            -ready been implemented, so just put in a dictionary with the
            fields and respective values to update the collection with.
        
        Returns: the number of documents that have been updated.
        """
        
        total_affected = 0
        try:
            if not isinstance(query, dict):
                raise Exception("parameter 'query' should be a dictionary.")
            elif not isinstance(data, dict):
                raise Exception("parameter 'data' should be a dictionary.")
            result = self.collection.update_many(
                query, { "$set": data }
            )
            total_affected += result.modified_count
        except Exception as e:
            print("Exception raised: {0}".format(e))
        return total_affected
    
    # "Delete" CRU[D] method
    def delete(self, query: dict) -> int:
        """
        A function that queries for and removes document(s) from a specified 
          MongoDB database and specified collection
          
        Args:
          query: a filter criteria.
          
        Returns: the number of documents that have been deleted.
        """
        total_affected = 0
        
        try:
            if not isinstance(query, dict):
                raise Exception("parameter 'query' should be a dictionary.")
            result = self.collection.delete_many(query)
            total_affected += result.deleted_count
        except Exception as e:
            print("Exception raised: {0}".format(e))

        return total_affected
    
    # TODO: Create a method to return the next available record number for use in the create method

#
# References
# 1. https://levelup.gitconnected.com/the-python-developers-survival-kit-15-best-practices-that-separate-pros-from-beginners-7d87ba661814
#
