/*
 * Copyright (C) 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.fortsoft.orientdb.example.domain;

/**
 * @author Decebal Suiu
 */
public class Address {

    private String street;
    private String postcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String zip) {
        this.postcode = zip;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Address[");
        builder.append("street=").append(getStreet()).append(",");
        builder.append("postcode=").append(getPostcode());
        builder.append("]");

        return builder.toString();
    }

}
