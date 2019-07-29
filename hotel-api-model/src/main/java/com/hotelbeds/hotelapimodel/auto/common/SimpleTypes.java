/**
 * Autogenerated code by SdkModelGenerator.
 * Do not edit. Any modification on this file will be removed automatically after project build
 *
 */
package com.hotelbeds.hotelapimodel.auto.common;

/*
 * #%L
 * HotelAPI Model
 * %%
 * Copyright (C) 2015 - 2018 HOTELBEDS GROUP, S.L.U.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class SimpleTypes.
 *
 * @author Hotelbeds Accommodation and Destination Services
 */
@Slf4j
public final class SimpleTypes {

    /** The Constant AGES_RATEKEY_SEPARATOR. */
    public static final String AGES_RATEKEY_SEPARATOR = "~";

    /** The Constant VALUE_TOKEN. */
    public static final String VALUE_TOKEN = "~";

    /** The Constant INDEX_0. */
    public static final int INDEX_0 = 0;

    /** The Constant INDEX_1. */
    public static final int INDEX_1 = 1;

    /** The Constant INDEX_2. */
    public static final int INDEX_2 = 2;

    /** The Constant RATE_KEY_SEPARATOR. */
    public static final String RATE_KEY_SEPARATOR = "|";

    /** The Constant ROOM_SEPARATOR. */
    public static final String ROOM_SEPARATOR = ".";

    /** The Constant ROOM_ATLAS_SEPARATOR. */
    public static final String ROOM_ATLAS_SEPARATOR = "-";

    /** The Constant OCCUPANCY_SEPARATOR. */
    public static final String OCCUPANCY_SEPARATOR = "~";

    /** The Constant SI_CODE. */
    public static final String SI_CODE = "s";

    public static final String ALL_B2B_CODE = "ALL";

    private static final String NO = "No";
    private static final String YES = "Yes";
    private static final String ONLY = "Only";
    private static final int STATUS_CONFIRMED = 0;
    private static final int STATUS_CANCELLED = 100;
    private static final int INTERNAL_STATUS_NEW = 200;
    private static final int INTERNAL_STATUS_TO_BE_UPDATED = 300;
    private static final int INTERNAL_STATUS_PRECONFIRMED = 500;
    private static final int INTERNAL_STATUS_CANCELLED = 400;
    private static final String SI = "Si";

    private SimpleTypes() {
    }

    /**
     * The Enum ChangeMode.
     *
     * @author vmavromatis
     */
    @XmlType(name = "ChangeMode")
    @XmlEnum
    public enum ChangeMode {
        SIMULATION(SiNo.S),
        UPDATE(SiNo.N);

        @Getter
        private SiNo internal;

        private ChangeMode(final SiNo internal) {
            this.internal = internal;
        }

        /**
         * Gets the BDD value.
         *
         * @return the BDD value
         */
        public String getBDDValue() {
            return internal.toString();
        }
    }

    /**
     * The Enum YesNo.
     *
     * @author vmavromatis
     */
    @XmlType(name = "YesNo")
    @XmlEnum
    public enum YesNo {
        Y(SimpleTypes.YES, SiNo.S, "Y"),
        N(SimpleTypes.NO, SiNo.N, "N"),
        O(SimpleTypes.ONLY, SiNo.N, "O");
        private String label;
        private SiNo internal;
        private String bddValue;

        private YesNo(final String label, final SiNo internal, final String bddValue) {
            this.label = label;
            this.internal = internal;
            this.bddValue = bddValue;
        }

        /**
         * Gets the label.
         *
         * @return the label
         */
        public String getLabel() {
            return label;
        }

        /**
         * Gets the internal.
         *
         * @return the internal
         */
        public SiNo getInternal() {
            return internal;
        }

        /**
         * Gets the BDD value.
         *
         * @return the BDD value
         */
        public String getBDDValue() {
            return bddValue;
        }

        /**
         * Gets the from boolean.
         *
         * @param value the value
         * @return the from boolean
         */
        public static YesNo getFromBoolean(final Boolean value) {
            if (value == null) {
                return null;
            } else if (Boolean.TRUE.equals(value)) {
                return YesNo.Y;
            } else {
                return YesNo.N;
            }
        }

        /**
         * Gets the safe value.
         *
         * @param value the value
         * @return the safe value
         */
        public static YesNo getSafeValue(final String value) {
            if (value != null) {
                if (SimpleTypes.SI_CODE.equalsIgnoreCase(value)) {
                    return YesNo.Y;
                } else {
                    return YesNo.valueOf(value);
                }
            } else {
                return YesNo.N;
            }
        }

        /**
         * Gets the boolean.
         *
         * @param yesNo the yes no
         * @return the boolean
         */
        public static boolean getBoolean(YesNo yesNo) {
            return YesNo.Y.equals(yesNo);
        }

        /**
         * Gets the boolean.
         *
         * @param value the value
         * @return the boolean
         */
        public static boolean getBoolean(Object value) {
            return "Y".equals(value) || "S".equals(value);
        }
    }

    /**
     * The Enum ShowDirectPayment.
     *
     * @author vmavromatis
     */
    public enum ShowDirectPayment {
        //liberate
        AT_HOTEL("S", "Y", "YES"),
        AT_WEB("N", "N", "NO"),
        BOTH("A", "A", "BOTH");
        private String aceLabel;
        private String ynaLabel;
        private String genericLabel;
        private static Map<String, ShowDirectPayment> showDirectPaymentByAceValue = new HashMap<>();

        static {
            for (ShowDirectPayment showDirectPayment : ShowDirectPayment.values()) {
                showDirectPaymentByAceValue.put(showDirectPayment.getAceLabel(), showDirectPayment);
            }
        }

        private ShowDirectPayment(final String aceLabel, final String ynaLabel, final String genericLabel) {
            this.aceLabel = aceLabel;
            this.ynaLabel = ynaLabel;
            this.genericLabel = genericLabel;
        }

        /**
         * Gets the ace label.
         *
         * @return the ace label
         */
        public String getAceLabel() {
            return aceLabel;
        }

        /**
         * Gets the generic label.
         *
         * @return the generic label
         */
        public String getGenericLabel() {
            return genericLabel;
        }

        /**
         * Gets the YNA label.
         *
         * @return the YNA label
         */
        public String getYNALabel() {
            return ynaLabel;
        }

        /**
         * Translates DirectPayments values from Ace to the ones used in Hotel-.
         *
         * @param value the value
         * @return the direct payment from ace value
         */
        public static ShowDirectPayment getDirectPaymentFromAceValue(final String value) {
            return showDirectPaymentByAceValue.get(value);
        }
    }

    /**
     * The Enum SiNo.
     *
     * @author vmavromatis
     */
    public enum SiNo {
        S(SI, YesNo.Y),
        N(NO, YesNo.N);
        private String label;
        private YesNo internal;

        private SiNo(final String label, final YesNo internal) {
            this.label = label;
            this.internal = internal;
        }

        /**
         * Gets the label.
         *
         * @return the label
         */
        public String getLabel() {
            return label;
        }

        /**
         * Gets the internal.
         *
         * @return the internal
         */
        public YesNo getInternal() {
            return internal;
        }

        /**
         * Gets the safe value.
         *
         * @param value the value
         * @return the safe value
         */
        public static SiNo getSafeValue(final String value) {
            if (SiNo.S.name().equalsIgnoreCase(value)) {
                return SiNo.S;
            } else {
                return SiNo.N;
            }
        }

        /**
         * To boolean.
         *
         * @return true, if successful
         */
        public boolean toBoolean() {
            return SiNo.S.equals(this) ? true : false;
        }

        /**
         * Gets the from boolean.
         *
         * @param value the value
         * @return the from boolean
         */
        public static SiNo getFromBoolean(Boolean value) {
            if (Boolean.TRUE.equals(value)) {
                return SiNo.S;
            } else {
                return SiNo.N;
            }
        }
    }

    /**
     * The Enum HotelbedsCustomerType.
     *
     * @author vmavromatis
     */
    public enum HotelbedsCustomerType {
        /**
         * Used for adult.
         */
        AD("2", 30, "A", "A", "AD", "AD")
        /**
         * Used for children.
         */
        ,
        CH("1", 8, "C", "N", "NI", "CH");
        private final String paxType;
        private final int defaultAge;
        private final String paxId;
        private final String paxCode;
        private final String atlasCode;
        private final String englishType;

        HotelbedsCustomerType(final String paxType, final int defaultAge, final String paxId, final String paxCode, final String atlasCode,
            final String englishType) {
            this.paxType = paxType;
            this.defaultAge = defaultAge;
            this.paxId = paxId;
            this.paxCode = paxCode;
            this.atlasCode = atlasCode;
            this.englishType = englishType;
        }

        /**
         * Gets the pax type.
         *
         * @return the pax type
         */
        public String getPaxType() {
            return paxType;
        }

        /**
         * Gets the default age.
         *
         * @return the default age
         */
        public int getDefaultAge() {
            return defaultAge;
        }

        /**
         * Gets the pax id.
         *
         * @return the pax id
         */
        public String getPaxId() {
            return paxId;
        }

        /**
         * Gets the pax code.
         *
         * @return the pax code
         */
        public String getPaxCode() {
            return paxCode;
        }

        /**
         * Gets the atlas code.
         *
         * @return the atlas code
         */
        public String getAtlasCode() {
            return atlasCode;
        }

        /**
         * Gets the english type.
         *
         * @return the english type
         */
        public String getEnglishType() {
            return englishType;
        }

        /**
         * Gets the customer type.
         *
         * @param customerType the customer type
         * @return the customer type
         */
        public static HotelbedsCustomerType getCustomerType(final String customerType) {
            if (customerType != null && isCustomerTypeAdult(customerType)) {
                return HotelbedsCustomerType.AD;
            } else {
                return HotelbedsCustomerType.CH;
            }
        }

        private static boolean isCustomerTypeAdult(String customerType) {
            HashSet<String> adultCustomerValues = new HashSet<>();
            adultCustomerValues.add(HotelbedsCustomerType.AD.getPaxId());
            adultCustomerValues.add(HotelbedsCustomerType.AD.getAtlasCode());
            adultCustomerValues.add(HotelbedsCustomerType.AD.getPaxCode());
            adultCustomerValues.add(HotelbedsCustomerType.AD.getPaxType());

            return adultCustomerValues.contains(customerType);
        }

        /**
         * Gets the customer type from pax id.
         *
         * @param paxId the pax id
         * @return the customer type from pax id
         */
        public static HotelbedsCustomerType getCustomerTypeFromPaxId(final String paxId) {
            if (HotelbedsCustomerType.AD.getPaxId().equals(paxId)) {
                return HotelbedsCustomerType.AD;
            } else {
                return HotelbedsCustomerType.CH;
            }
        }
    }

    /**
     * The Enum HotelbedsTicketClass.
     *
     * @author vmavromatis
     */
    public enum HotelbedsTicketClass {
        T,
        E
    }

    /**
     * The Enum RateType.
     *
     * @author vmavromatis
     */
    public enum RateType {
        BOOKABLE,
        RECHECK
    }

    /**
     * The Enum CommissionType.
     *
     * @author vmavromatis
     */
    public enum CommissionType {
        LIBERATE_RATE("L"),
        NET_RATE("N"),
        COMISSIONABLE_RATE("O"),
        COMISSIONABLE_DISCOUNT_RATE("V");
        private final String type;

        private CommissionType(String type) {
            this.type = type;
        }

        /**
         * Gets the type.
         *
         * @return the type
         */
        public String getType() {
            return type;
        }

        /**
         * Gets the commission type.
         *
         * @param commissionType the commission type
         * @return the commission type
         */
        public static CommissionType getCommissionType(final String commissionType) {
            CommissionType result = null;
            if (CommissionType.LIBERATE_RATE.type.equals(commissionType)) {
                result = CommissionType.LIBERATE_RATE;
            } else if (CommissionType.NET_RATE.type.equals(commissionType)) {
                result = CommissionType.NET_RATE;
            } else if (CommissionType.COMISSIONABLE_RATE.type.equals(commissionType)) {
                result = CommissionType.COMISSIONABLE_RATE;
            } else if (CommissionType.COMISSIONABLE_DISCOUNT_RATE.type.equals(commissionType)) {
                result = CommissionType.COMISSIONABLE_DISCOUNT_RATE;
            }
            return result;
        }
    }

    /**
     * The Enum PaymentType.
     *
     * @author vmavromatis
     */
    public enum PaymentType {
        AT_HOTEL("P", "H"),
        AT_WEB("C", "W");
        private final String abbreviated;
        private final String rateKeyValue;

        private PaymentType(String abbreviated, String rateKeyValue) {
            this.abbreviated = abbreviated;
            this.rateKeyValue = rateKeyValue;
        }

        /**
         * Gets the abbreviated.
         *
         * @return the abbreviated
         */
        public String getAbbreviated() {
            return abbreviated;
        }

        /**
         * Gets the rate key value.
         *
         * @return the rate key value
         */
        public String getRateKeyValue() {
            return rateKeyValue;
        }

        /**
         * Gets the payment type.
         *
         * @param directPayment the direct payment
         * @return the payment type
         */
        public static PaymentType getPaymentType(final boolean directPayment) {
            PaymentType result;
            if (directPayment) {
                result = PaymentType.AT_HOTEL;
            } else {
                result = PaymentType.AT_WEB;
            }
            return result;
        }

        /**
         * Gets the payment type.
         *
         * @param paymentType the payment type
         * @return the payment type
         */
        public static PaymentType getPaymentType(final String paymentType) {
            if (paymentType != null
                && (paymentType.equals(PaymentType.AT_HOTEL.abbreviated) || paymentType.equals(PaymentType.AT_HOTEL.name()) || paymentType
                    .equals(PaymentType.AT_HOTEL.rateKeyValue))) {
                return PaymentType.AT_HOTEL;
            } else {
                return PaymentType.AT_WEB;
            }
        }
    }

    /**
     * The Enum SupplementType.
     *
     * @author vmavromatis
     */
    public enum SupplementType {
        SUPPLEMENT("S"),
        DISCOUNT("D");
        private final String abbreviated;

        private SupplementType(String abbreviated) {
            this.abbreviated = abbreviated;
        }

        /**
         * Gets the abbreviated.
         *
         * @return the abbreviated
         */
        public String getAbbreviated() {
            return abbreviated;
        }

        /**
         * Gets the supplement type.
         *
         * @param supplementType the supplement type
         * @return the supplement type
         */
        public static SupplementType getSupplementType(final String supplementType) {
            SupplementType result = null;
            if (supplementType != null
                && (supplementType.equals(SupplementType.SUPPLEMENT.abbreviated) || supplementType.equals(SupplementType.SUPPLEMENT.name()))) {
                result = SupplementType.SUPPLEMENT;
            } else if (supplementType != null
                && (supplementType.equals(SupplementType.DISCOUNT.abbreviated) || supplementType.equals(SupplementType.DISCOUNT.name()))) {
                result = SupplementType.DISCOUNT;
            }
            return result;
        }
    }

    /**
     * The Enum TypeRequestAvail.
     *
     * @author vmavromatis
     */
    public enum TypeRequestAvail {
        TYPE_REQUEST_VALUATION_AVAIL,
        TYPE_REQUEST_AVAIL
    }

    /**
     * The Enum ProviderAvail.
     *
     * @author vmavromatis
     */
    public enum ProviderAvail {
        ACE,
        CARONTE
    }

    /**
     * The Enum CancellationFlags.
     *
     * @author vmavromatis
     */
    public enum CancellationFlags {
        CANCELLATION("C"),
        SIMULATION("S");
        private String flag;

        private CancellationFlags(final String flag) {
            this.flag = flag;
        }

        /**
         * Gets the flag.
         *
         * @return the flag
         */
        public String getFlag() {
            return flag;
        }

        /**
         * Gets the cancellation flag.
         *
         * @param value the value
         * @return the cancellation flag
         */
        public static CancellationFlags getCancellationFlag(final String value) {
            if (value != null && value.equalsIgnoreCase(CancellationFlags.SIMULATION.name())) {
                return CancellationFlags.SIMULATION;
            } else {
                return CancellationFlags.CANCELLATION;
            }
        }
    }

    /**
     * The Enum BookingListFilterType.
     *
     * @author vmavromatis
     */
    public enum BookingListFilterType {
        //E: busca por fechas de Entrada (Checking)
        CHECKIN("E"),
        //C: Busca por fechas de creación
        CREATION("C"),
        //M: Busca por fechas de modificacion
        MODIFIED("M");
        private String type;


        private BookingListFilterType(final String type) {
            this.type = type;
        }

        /**
         * Gets the type.
         *
         * @return the type
         */
        public String getType() {
            return type;
        }

        /**
         * Gets the booking list filter type.
         *
         * @param type the type
         * @return the booking list filter type
         */
        public static BookingListFilterType getBookingListFilterType(final String type) {
            if (type != null && type.equalsIgnoreCase(BookingListFilterType.CREATION.name())) {
                return BookingListFilterType.CREATION;
            } else {
                //Por defecto filterType de bookingList vale "E" = "CHECKIN"
                return BookingListFilterType.CHECKIN;
            }
        }
    }

    /**
     * The Enum BookingListFilterStatus.
     *
     * @author vmavromatis
     */
    public enum BookingListFilterStatus {
        CONFIRMED("N"),
        CANCELED("Y"),
        CANCELLED("Y"),
        ALL("A");

        private final String atlasCode;

        private BookingListFilterStatus(String atlasCode) {
            this.atlasCode = atlasCode;
        }

        /**
         * Gets the atlas code.
         *
         * @return the atlas code
         */
        public String getAtlasCode() {
            return atlasCode;
        }
    }


    /**
     * The Enum VoucherStyleAction.
     */
    public enum VoucherStyleAction {
        GET,
        UPDATE
    }


    /**
     * The Enum Accommodation.
     *
     */
    public enum Accommodation {
        HOTEL("HOTEL"),
        APARTMENT("APART"),
        RURAL("RURAL"),
        HOSTEL("HOSTEL"),
        APTHOTEL("APTHOTEL"),
        CAMPING("CAMPING"),
        HISTORIC("HOTEL "),
        PENDING("PENDING"),
        RESORT("RESORT"),
        HOMES("HOMES");
        private String type;
        private static Map<String, Accommodation> accommodationsByType = new HashMap<>();

        static {
            for (Accommodation accommodation : Accommodation.values()) {
                accommodationsByType.put(accommodation.getType(), accommodation);
            }
        }

        Accommodation(final String type) {
            this.type = type;
        }

        /**
         * Gets the type.
         *
         * @return the type
         */
        public String getType() {
            return type;
        }

        /**
         * Gets the accommodations by type.
         *
         * @param type the type
         * @return the accommodations by type
         */
        public static Accommodation getAccommodationsByType(final String type) {
            Accommodation result = accommodationsByType.get(type.toUpperCase());
            if (result == null) {
                result = Accommodation.HOMES;
            }
            return result;
        }
    }

    /**
     * The Enum HotelCodeType.
     *
     * @author vmavromatis
     */
    public enum HotelCodeType {
        HOTELBEDS,
        GIATA;
    }

    /**
     * The Enum ChannelType.
     *
     * @author vmavromatis
     */
    public enum ChannelType {
        B2B,
        B2C,
        META,
        NEWSLETTER;
    }

    /**
     * The Enum DeviceType.
     *
     * @author vmavromatis
     */
    public enum DeviceType {
        MOBILE,
        WEB,
        TABLET;
    }

    /**
     * The Enum ReviewsType.
     *
     * @author vmavromatis
     */
    public enum ReviewsType {
        TRIPADVISOR("TRIPADVISOR"),
        HOTELBEDS("HOTELBEDS");
        private String requestType;

        ReviewsType(final String type) {
            requestType = type;
        }

        /**
         * Gets the request type.
         *
         * @return the request type
         */
        public String getRequestType() {
            return requestType;
        }

        /**
         * Gets the reviews type.
         *
         * @param requestType the request type
         * @return the reviews type
         */
        public static ReviewsType getReviewsType(final String requestType) {
            ReviewsType result = null;
            if (requestType != null && (requestType.equalsIgnoreCase(ReviewsType.TRIPADVISOR.getRequestType()))) {
                result = ReviewsType.TRIPADVISOR;
            } else if (requestType != null && requestType.equalsIgnoreCase(ReviewsType.HOTELBEDS.getRequestType())) {
                result = ReviewsType.HOTELBEDS;
            }
            return result;
        }
    }

    /**
     * The Enum AvailabilitySorter.
     *
     * @author vmavromatis
     */
    public enum AvailabilitySorter {
        RATE("P"),
        PRIORITY("");
        private String cachedValue;

        AvailabilitySorter(String cachedValue) {
            this.cachedValue = cachedValue;
        }

        /**
         * Gets the cached value.
         *
         * @return the cached value
         */
        public String getCachedValue() {
            return cachedValue;
        }
    }

    /**
     * The Enum TaxType.
     *
     * @author vmavromatis
     */
    public enum TaxType {
        TAX("T"),
        FEE("F"),
        TAXESANDFEES("TF");
        private String internalCode;

        TaxType(String internalCode) {
            this.internalCode = internalCode;
        }

        /**
         * Gets the internal code.
         *
         * @return the internal code
         */
        public String getInternalCode() {
            return internalCode;
        }

        /**
         * Gets the tax type.
         *
         * @param internalCode the internal code
         * @return the tax type
         */
        public static TaxType getTaxType(String internalCode) {
            TaxType result = null;
            if (TAX.getInternalCode().equals(internalCode)) {
                result = TAX;
            } else if (FEE.getInternalCode().equals(internalCode)) {
                result = FEE;
            } else if (TAXESANDFEES.getInternalCode().equals(internalCode)) {
                result = TAXESANDFEES;
            } else {
                log.debug("TaxType not found with this internalCode: " + internalCode);
            }
            return result;
        }
    }

    /**
     * The Enum HotelPackage.
     *
     * @author vmavromatis
     */
    public enum HotelPackage {
        YES,
        NO,
        BOTH
    }

    /**
     * The Enum ShoppingCartStatus.
     *
     * @author vmavromatis
     */
    public enum ShoppingCartStatus {
        NEW(INTERNAL_STATUS_NEW),
        PRECONFIRMED(INTERNAL_STATUS_PRECONFIRMED),
        CONFIRMED(STATUS_CONFIRMED),
        TO_BE_UPDATED(INTERNAL_STATUS_TO_BE_UPDATED),
        CANCELLED(STATUS_CANCELLED),
        TO_BE_CANCELLED(INTERNAL_STATUS_CANCELLED);

        private static final Map<Integer, ShoppingCartStatus> STATUS_BY_CODE = new HashMap<>();
        private final int code;

        ShoppingCartStatus(final int code) {
            this.code = code;
        }

        /**
         * Gets the code.
         *
         * @return the code
         */
        public int getCode() {
            return code;
        }


        /**
         * With code.
         *
         * @param code the code
         * @return the shopping cart status
         */
        public static final ShoppingCartStatus withCode(final int code) {
            return STATUS_BY_CODE.get(code);
        }

        static {
            for (ShoppingCartStatus shoppingCartStatus : ShoppingCartStatus.values()) {
                STATUS_BY_CODE.put(shoppingCartStatus.getCode(), shoppingCartStatus);
            }
        }
    }

    /**
     * The Enum PriceFilterType.
     *
     * @author vmavromatis
     */
    public enum PriceFilterType {
        TOTAL("Total"),
        PRICE_PER_NIGHT("Night");

        private String label;

        PriceFilterType(String label) {
            this.label = label;
        }

        /**
         * Gets the label.
         *
         * @return the label
         */
        public String getLabel() {
            return label;
        }
    }

}
