# DicomExtractor

This project can be used for extracting Dicom image from a file and storing the metadata. This project uses the ImageJ library which has a DICOM class.

Usage:

* Make sure Maven in installed in your system.
* Install MongoDB
* Clone this repository
```
git clone https://github.com/aswinigh/DicomExtractor.git

```
* Go to dicom-extract folder
```
cd dicom-extract
```
* Install dependencies using maven:
```
mvn install
```
* Execute using:
```
mvn exec:java -Dexec.args="/path/to/dicom.dcm"
```
## References:
* https://imagej.nih.gov/ij/developer/api/ij/plugin/DICOM.html
* https://www.youtube.com/watch?v=Mp2CPA-3a6Q
