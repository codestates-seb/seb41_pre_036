import React from "react";
import Footer from "../../components/Footer";
import LayoutContainer from "../../components/LayoutContainer";
import PageContainer from "../../components/PageContainer";
import Sidebar from "../../components/Sidebar";
import Header from "../../components/Header";

export default function QuestionsList() {
  return (
    <>
      <Header />
      <Sidebar />
      <LayoutContainer>
        <PageContainer>QuestionsList</PageContainer>
      </LayoutContainer>
      <Footer />
    </>
  );
}
