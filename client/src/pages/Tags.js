import React from "react";
import { useState } from "react";
import Footer from "../components/Footer";
import Header from "../components/Header";
import LayoutContainer from "../components/LayoutContainer";
import PageContainer from "../components/PageContainer";
import Sidebar from "../components/Sidebar";
import axios from "axios";
import { useEffect } from "react";
import TagsHeader from "../components/TagsHeader";
import styled from "styled-components";
import TagCard from "../components/TagCard";

const TagsBox = styled.div`
  padding: 24px;
`;

const TagBoxGrid = styled.ul`
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
  grid-gap: 20px;
  width: 100%;
  @media screen and (max-width: 1345px) {
    grid-template-columns: repeat(3, minmax(0, 1fr));
  }
  @media screen and (max-width: 1028px) {
    grid-template-columns: repeat(2, minmax(0, 1fr));
  }
  @media screen and (max-width: 711px) {
    grid-template-columns: repeat(1, minmax(0, 1fr));
  }
`;

export default function Tags() {
  const [tags, setTags] = useState([]);

  // 페이지네이션
  const [limit, setLimit] = useState(36);
  const [page, setPage] = useState(1);
  const [sort, setSort] = useState("Popular");
  const offset = (page - 1) * limit;

  // 정렬
  const [order, setOrder] = useState("desc");

  // Input의 입력값
  const [value, setValue] = useState("");

  // API data
  const data1 = async () => {
    try {
      const tagList = await (
        await axios.get(
          `https://api.stackexchange.com/2.3/tags?pagesize=100&order=${order}&sort=${sort}&site=stackoverflow`
        )
      ).data;
      setTags(tagList.items);
    } catch (error) {
      throw new Error(error);
    }
  };
  const data2 = async () => {
    try {
      const tagList = await (
        await axios.get(
          `https://api.stackexchange.com/2.3/tags?pagesize=100&order=${order}&sort=${sort}&inname=${value}&site=stackoverflow`
        )
      ).data;
      setTags(tagList.items);
    } catch (error) {
      throw new Error(error);
    }
  };

  useEffect(() => {
    if (value === "") {
      data1();
    } else {
      data2();
    }
    // if (value === "") {
    //   fetch(
    //     `https://api.stackexchange.com/2.3/tags?pagesize=100&order=${order}&sort=${sort}&site=stackoverflow`
    //   )
    //     .then((res) => {
    //       if (!res.ok) {
    //         throw Error("could not fetch the data for that resource");
    //       }
    //       return res.json();
    //     })
    //     .then((data) => setTags(data.items))
    //     .catch((error) => {
    //       throw new Error(error);
    //     });

    //   // tag 검색 시
    // } else {
    //   fetch(
    //     `https://api.stackexchange.com/2.3/tags?pagesize=100&order=${order}&sort=${sort}&inname=${value}&site=stackoverflow`
    //   )
    //     .then((res) => {
    //       if (!res.ok) {
    //         throw Error("could not fetch the data for that resource");
    //       }
    //       return res.json();
    //     })
    //     .then((data) => setTags(data.items))
    //     .catch((error) => {
    //       throw new Error(error);
    //     });
    // }
  }, [value, sort]);
  console.log(order);
  return (
    <>
      <Header />
      <Sidebar />
      <LayoutContainer>
        <PageContainer>
          <TagsBox>
            <TagsHeader
              setSort={setSort}
              sort={sort}
              setOrder={setOrder}
              setValue={setValue}
              value={value}
            />
            <TagBoxGrid>
              {tags.slice(offset, offset + limit).map((tag, idx) => (
                <TagCard key={idx} name={tag.name} count={tag.count} />
              ))}
            </TagBoxGrid>
          </TagsBox>
        </PageContainer>
      </LayoutContainer>
      <Footer />
    </>
  );
}
