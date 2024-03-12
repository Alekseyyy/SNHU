
<a href="https://tryhackme.com/room/iosforensics" target="_blank"><img src="./banner.png" width="700px" /></a>

## Background

This room discusses basic analysis techniques regarding the analysis of forensic data from Apple iOS devices. It does briefly discuss the acquisition process, but does not demonstrate it. Instead, we are given artefacts to analyse and there is more emphasis on forensic data analysis.

### Video Tutorial by DarkSec:

[![iOS Forensics Walkthrough by DarkStar7471](https://img.youtube.com/vi/21v1snB7NMw/0.jpg)](https://www.youtube.com/watch?v=21v1snB7NMw)

### Materials

* [OpJustEncase.zip](./materials/OpJustEncase.zip): forensic artefact data from a hypothetical imaging of an iOS device.
* Images depicting old Cellebrite UFED Extractors and various phone adapters:
    * Retrieved on Mar. 11, 2024 from: https://i.imgur.com/j9I6ZJ0.png
    * Retrieved on Mar. 11, 2024 from: http://www.itechdataforensics.com/images/UFED%20CELLEBRITE%20MOBILE%20FORENSICS%20EQUIPMENT%20MUMBAI%20INDIA1.jpg
* Image depicting Apple iOS "Restricted Mode" (Retrieved on Mar. 11, 2024 from): https://blog.elcomsoft.com/wp-content/uploads/2018/09/screen0.png

## Takeaways

I won't go too much into the process of doing this room, as [DarkSec (Sept. 27, 2020)](https://www.youtube.com/watch?v=21v1snB7NMw)'s video tutorial does a good job covering it. But I did want to take note of the following of what I found to be interesting:

* Regarding external resources,
    * [Apple Developer Documentation (n.d.)](https://developer.apple.com/documentation/foundation/file_system/about_apple_file_system) discusses technical aspects of the Apple File System.
    * [Association of Chief of Police Officers (2012)](https://www.digital-detective.net/digital-forensics-documents/ACPO_Good_Practice_Guide_for_Digital_Evidence_v5.pdf) documents the standards used by the UK police to reliably acquire forensic evidence.
    * [Farley (2019)](https://farleyforensics.com/2019/04/14/forensic-analysis-of-itunes-backups/) gives a tutorial on how to analyse an iTunes backup.
    * [Vigo (2018)](https://www.techrepublic.com/article/apfs-vs-hfs-which-apple-filesystem-is-better/) compares and contrasts the differences between different Apple filesystems.
* While doing research based on the contents of this room, I came across a scholar called [Roshidi Din](https://scholar.google.com/citations?user=Ilpw2NoAAAAJ&hl=en) who has published research articles about cryptography and stenography.
* Empty hard-drives are usually more suspicious than non-empty ones.
* An __image__ is what is referred to as an abstract view of a storage medium.
* Free tools like __FTK Imager Lite__ and __Autopsy__ typically aren't powerful enough to image smartphones.
    * Companies like [Cellebrite](https://cellebrite.com/en/home/) develop tools designed for this.
    * The Apple iOS device typically does not trust a foreign desktop/laptop computer by default. If the iOS device can be "convinced" into trusting said iOS device, then a __trust certificate__ will be placed in the trusted computer.
* Direct Acquition can be used in the case of an iOS device without a passcode lock.
* The [iFunBox app](https://www.i-funbox.com/en/index.html) __should not__ be used in forensic investigations, as it writes data to the iOS device and threatens the integrity of the investigation.

## References

* Apple Developer Documentation (n.d.). _About Apple File System: Use high-level APIs to get the most out of Apple File System._ Last Retrieved Mar. 11, 2024 from: https://developer.apple.com/documentation/foundation/file_system/about_apple_file_system
* Association of Chief of Police Officers (2012). _ACPO Good Practice Guide for Digital Evidence._ Retrieved on Mar. 11, 2024 from: https://www.digital-detective.net/digital-forensics-documents/ACPO_Good_Practice_Guide_for_Digital_Evidence_v5.pdf
* Farley, J. (2019). _Forensic Analysis of iTunes Backups._ Farley Forensics. Retrieved on Mar. 11, 2024 from: https://farleyforensics.com/2019/04/14/forensic-analysis-of-itunes-backups/
* Vigo, J. (2018). _HFS+ v. APFS: Which Apple file system is better?_ TechRepublic. Last Retrieved on Mar. 11, 2024 from: https://www.techrepublic.com/article/apfs-vs-hfs-which-apple-filesystem-is-better/

