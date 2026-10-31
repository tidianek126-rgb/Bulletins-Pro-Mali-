android {
    ...
    signingConfigs {
        create("release") {
            storeFile = file(System.getenv("SIGNING_KEY_STORE_PATH") ?: "bulletin_mali_release.jks")
            storePassword = System.getenv("SIGNING_STORE_PASSWORD") ?: "MaliEducation2026"
            keyAlias = System.getenv("SIGNING_KEY_ALIAS") ?: "bulletin_mali"
            keyPassword = System.getenv("SIGNING_KEY_PASSWORD") ?: "MaliEducation2026"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
        }
    }
}