## DicomExtractor

This project can be used for extracting Dicom image from a file and storing the metadata.

Usage:

* Make sure Maven in installed in your system.
* Clone this repository and go to dicom-extract folder
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
