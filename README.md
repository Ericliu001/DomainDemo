# DomainDemo


There are 2 productFlavors: prod is normal flavor which retrieves real data from the server; mock is using mock data from a json file saved in the raw directory.




     productFlavors {
        mock {
            applicationIdSuffix = ".mock"
            versionName "1.0-mock"
        }
        prod {
            versionName "1.0-prod"
        }
    }

