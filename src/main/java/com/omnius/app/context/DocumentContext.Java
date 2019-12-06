package com.omnius.app.context;

public class DocumentContext {
    private String documentName;
    private String uploadFilePath;
    private boolean validDocument;
    private String sob;
    private String auftragsdatum;
    private String rechnungsnummer;
    private String kundennummer;
    private String vob;
    private boolean finalize;

    public boolean isFinalize() {
        return finalize;
    }

    public void setFinalize(boolean finalize) {
        this.finalize = finalize;
    }

    public String getSob() {
        return sob;
    }

    public void setSob(String sob) {
        this.sob = sob;
    }

    public String getAuftragsdatum() {
        return auftragsdatum;
    }

    public void setAuftragsdatum(String auftragsdatum) {
        this.auftragsdatum = auftragsdatum;
    }

    public String getRechnungsnummer() {
        return rechnungsnummer;
    }

    public void setRechnungsnummer(String rechnungsnummer) {
        this.rechnungsnummer = rechnungsnummer;
    }

    public String getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(String kundennummer) {
        this.kundennummer = kundennummer;
    }

    public String getVob() {
        return vob;
    }

    public void setVob(String vob) {
        this.vob = vob;
    }

    public boolean isValidDocument() {
        return validDocument;
    }

    public void setValidDocument(boolean validDocument) {
        this.validDocument = validDocument;
    }

    public String getUploadFilePath() {
        return uploadFilePath;
    }

    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }
}
